package com.tdn.data.repository;

import android.content.Context;
import android.util.Log;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.LokasiModel;
import com.tdn.domain.model.TitikModel;
import com.tdn.domain.object.LokasiObject;
import com.tdn.domain.object.TitikObject;
import com.tdn.domain.serialize.res.ResponseGetLokasi;
import com.tdn.domain.serialize.res.ResponseGetTitik;


import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public class Repository {
    public static final String TAG = "LAPORAN :: ";
    private static ApiService service;
    private static Repository repository;
    private static Realm realm;

    private Repository() {
        realm = Realm.getDefaultInstance();
        service = ApiService.Factory.create();
    }

    public synchronized static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public static ApiService getService() {
        if (service == null) {
            service = ApiService.Factory.create();
        }
        return service;
    }

    public void getAllLokasi() {
        service.getAllLokasi().enqueue(new Callback<ResponseGetLokasi>() {
            @Override
            public void onResponse(Call<ResponseGetLokasi> call, Response<ResponseGetLokasi> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(LokasiObject.class);
                            realm.commitTransaction();
                            if (response.body().getData().size() > 0) {
                                for (LokasiModel m : response.body().getData()) {
                                    LokasiObject o = (LokasiObject) m.ToObject();
                                    realm.executeTransaction(realm -> realm.copyToRealmOrUpdate(o));

                                }
                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(LokasiObject.class);
                            realm.commitTransaction();
                        }
                    } else {
                        realm.beginTransaction();
                        realm.delete(LokasiObject.class);
                        realm.commitTransaction();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetLokasi> call, Throwable t) {

            }
        });
    }

    public void getAllTitik() {
        service.getTitik().enqueue(new Callback<ResponseGetTitik>() {
            @Override
            public void onResponse(Call<ResponseGetTitik> call, Response<ResponseGetTitik> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(TitikObject.class);
                            realm.commitTransaction();
                            if (response.body().getData().size() > 0) {
                                for (TitikModel m : response.body().getData()) {
                                    TitikObject o = (TitikObject) m.ToObject();
                                    realm.executeTransaction(realm -> {
                                        realm.copyToRealmOrUpdate(o);
                                    });

                                }
                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(LokasiObject.class);
                            realm.commitTransaction();
                        }
                    } else {
                        realm.beginTransaction();
                        realm.delete(LokasiObject.class);
                        realm.commitTransaction();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetTitik> call, Throwable t) {

            }
        });
    }

}
