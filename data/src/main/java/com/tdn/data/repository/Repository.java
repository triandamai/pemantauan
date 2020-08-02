package com.tdn.data.repository;

import android.content.Context;
import android.util.Log;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.HomeModel;
import com.tdn.domain.model.NotifikasiModel;
import com.tdn.domain.model.ObatModel;
import com.tdn.domain.model.PenjualanDetailModel;
import com.tdn.domain.model.PenjualanModel;
import com.tdn.domain.model.PenjualanTempModel;
import com.tdn.domain.object.HomeObject;
import com.tdn.domain.object.NotifikasiObject;
import com.tdn.domain.object.ObatObject;
import com.tdn.domain.object.PenjualanDetailObject;
import com.tdn.domain.object.PenjualanObject;
import com.tdn.domain.object.PenjualanTempObject;
import com.tdn.domain.serialize.res.ResponseGetHome;
import com.tdn.domain.serialize.res.ResponseGetNotifikasi;
import com.tdn.domain.serialize.res.ResponseGetObat;
import com.tdn.domain.serialize.res.ResponseGetPenjualan;
import com.tdn.domain.serialize.res.ResponseGetPenjualanTemp;
import com.tdn.domain.serialize.res.ResponsePenjualanDetail;


import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class Repository {
    public static final String TAG = "LAPORAN :: ";
    private static ApiService service;
    private static Repository repository;
    private static Realm realm;
    private Context context;

    private Repository(Context ctx) {
        realm = Realm.getDefaultInstance();
        service = ApiService.Factory.create();
        context = ctx;
    }

    public synchronized static Repository getInstance(Context context) {
        if (repository == null) {
            repository = new Repository(context);
        }
        return repository;
    }

    public static ApiService getService() {
        if (service == null) {
            service = ApiService.Factory.create();
        }
        return service;
    }

    public void getObats() {
        service.getObat().enqueue(new Callback<ResponseGetObat>() {
            @Override
            public void onResponse(Call<ResponseGetObat> call, Response<ResponseGetObat> response) {
                if (cek(response.code())) {
                    //Log.e(TAG, response.body().toString());
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(ObatObject.class);
                            realm.commitTransaction();
                            for (ObatModel data : response.body().getData()) {
                                ObatObject o = (ObatObject) data.ToObject();
                                realm.executeTransaction(realm -> {
                                    realm.copyToRealmOrUpdate(o);
                                });
                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(ObatObject.class);
                            realm.commitTransaction();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetObat> call, Throwable t) {

            }
        });

    }

    public void getPenjualanTemp() {
        service.getPenjualanTemp().enqueue(new Callback<ResponseGetPenjualanTemp>() {
            @Override
            public void onResponse(Call<ResponseGetPenjualanTemp> call, Response<ResponseGetPenjualanTemp> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (cek(response.body().getResponseCode())) {
                            if (response.body().getData() != null) {
                                realm.beginTransaction();
                                realm.delete(PenjualanTempObject.class);
                                realm.commitTransaction();
                                for (PenjualanTempModel data : response.body().getData()) {
                                    PenjualanTempObject o = (PenjualanTempObject) data.ToObject();
                                    realm.executeTransaction(realm -> {
                                        realm.copyToRealmOrUpdate(o);
                                    });
                                }
                            } else {
                                realm.beginTransaction();
                                realm.delete(PenjualanTempObject.class);
                                realm.commitTransaction();
                            }
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<ResponseGetPenjualanTemp> call, Throwable t) {

            }
        });


    }

    public void getPenjualan() {
        service.getPenjualan().enqueue(new Callback<ResponseGetPenjualan>() {
            @Override
            public void onResponse(Call<ResponseGetPenjualan> call, Response<ResponseGetPenjualan> response) {
                if (cek(response.code())) {

                    if (cek(response.body().getResponseCode())) {

                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(PenjualanObject.class);
                            realm.commitTransaction();
                            if (response.body().getData().size() >= 1) {

                                for (PenjualanModel data : response.body().getData()) {
                                    PenjualanObject o = (PenjualanObject) data.ToObject();
                                    realm.executeTransaction(realm -> {
                                        realm.copyToRealmOrUpdate(o);
                                    });
                                }

                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(PenjualanObject.class);
                            realm.commitTransaction();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetPenjualan> call, Throwable t) {

            }
        });


    }

    public void getPenjualanDetail() {
        service.getPenjualanDetail().enqueue(new Callback<ResponsePenjualanDetail>() {
            @Override
            public void onResponse(Call<ResponsePenjualanDetail> call, Response<ResponsePenjualanDetail> response) {
                if (cek(response.code())) {
                    //Log.e(TAG, response.body().toString());

                    if (cek(response.body().getResponseCode())) {

                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(PenjualanDetailObject.class);
                            realm.commitTransaction();
                            if (response.body().getData().size() >= 1) {

                                for (PenjualanDetailModel data : response.body().getData()) {
                                    PenjualanDetailObject o = (PenjualanDetailObject) data.ToObject();
                                    realm.executeTransaction(realm -> {
                                        realm.copyToRealmOrUpdate(o);
                                    });
                                }
                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(PenjualanDetailObject.class);
                            realm.commitTransaction();
                        }
                    }
                }


            }

            @Override
            public void onFailure(Call<ResponsePenjualanDetail> call, Throwable t) {

            }
        });
    }

    public void getHome() {
        service.getHome().enqueue(new Callback<ResponseGetHome>() {
            @Override
            public void onResponse(Call<ResponseGetHome> call, Response<ResponseGetHome> response) {
                if (cek(response.code())) {
                    //Log.e(TAG, response.body().toString());

                    if (cek(response.body().getResponseCode())) {

                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(HomeObject.class);
                            realm.commitTransaction();


                            HomeObject o = (HomeObject) response.body().getData().ToObject();
                            realm.executeTransaction(realm -> {
                                realm.copyToRealmOrUpdate(o);
                            });


                        } else {
                            realm.beginTransaction();
                            realm.delete(HomeObject.class);
                            realm.commitTransaction();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetHome> call, Throwable t) {

            }
        });

    }

    public void getNotifikasi() {
        service.getNotifikasi().enqueue(new Callback<ResponseGetNotifikasi>() {
            @Override
            public void onResponse(Call<ResponseGetNotifikasi> call, Response<ResponseGetNotifikasi> response) {
                if (cek(response.code())) {
                    Log.e(TAG, response.body().getData().toString());

                    if (cek(response.body().getResponseCode())) {

                        if (response.body().getData() != null) {
                            realm.beginTransaction();
                            realm.delete(NotifikasiObject.class);
                            realm.commitTransaction();
                            if (response.body().getData().size() > 0) {

                                for (NotifikasiModel item : response.body().getData()) {
                                    NotifikasiObject o = (NotifikasiObject) item.ToObject();
                                    realm.executeTransaction(realm -> {
                                        realm.copyToRealmOrUpdate(o);
                                    });
                                }

                            }
                        } else {
                            realm.beginTransaction();
                            realm.delete(NotifikasiObject.class);
                            realm.commitTransaction();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetNotifikasi> call, Throwable t) {

            }
        });

    }

}
