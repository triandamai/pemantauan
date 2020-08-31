package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.JumlahMasukModel;
import com.tdn.domain.model.JumlahBelumMasukModel;
import com.tdn.domain.model.JumlahPegawaiModel;
import com.tdn.domain.serialize.res.ResponseGetJumlahBelumMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahPegawai;
import com.tdn.domain.serialize.res.ResponseGetLokasi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class HomeAdminViewModel extends ViewModel {
    private ApiService apiService;


    public HomeAdminViewModel() {
        this.apiService = ApiService.GatsuFactory.create();
        getJumlahMasuk();
        getJumlahPegawai();
        getJumlahBelumMasuk();
    }

    public LiveData<JumlahMasukModel> getJumlahMasuk() {
        final MutableLiveData<JumlahMasukModel> masuk = new MutableLiveData<>();
        apiService.getJumlahMasuk().enqueue(new Callback<ResponseGetJumlahMasuk>() {
            @Override
            public void onResponse(Call<ResponseGetJumlahMasuk> call, Response<ResponseGetJumlahMasuk> response) {
                if (cek(response.code())) {
                    if (response.body().getData() != null) {
                        if (response.body().getData().size() > 0) {
                            JumlahMasukModel mmodel = response.body().getData().get(0);
                            masuk.setValue(mmodel);
                        } else {
                            masuk.setValue(null);
                        }
                    } else {
                        masuk.setValue(null);
                    }
                } else {
                    masuk.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetJumlahMasuk> call, Throwable t) {
                masuk.setValue(null);
            }
        });
        return masuk;
    }

    public LiveData<JumlahBelumMasukModel> getJumlahBelumMasuk() {
        final MutableLiveData<JumlahBelumMasukModel> belummasuk = new MutableLiveData<>();
        apiService.getBelumMasuk().enqueue(new Callback<ResponseGetJumlahBelumMasuk>() {
            @Override
            public void onResponse(Call<ResponseGetJumlahBelumMasuk> call, Response<ResponseGetJumlahBelumMasuk> response) {
                if (cek(response.code())) {
                    if (response.body().getData() != null) {
                        if (response.body().getData().size() > 0) {
                            JumlahBelumMasukModel model = response.body().getData().get(0);
                            belummasuk.setValue(model);
                        } else {
                            belummasuk.setValue(null);
                        }
                    } else {
                        belummasuk.setValue(null);
                    }
                } else {
                    belummasuk.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetJumlahBelumMasuk> call, Throwable t) {
                belummasuk.setValue(null);
            }
        });
        return belummasuk;
    }

    public LiveData<JumlahPegawaiModel> getJumlahPegawai() {
        final MutableLiveData<JumlahPegawaiModel> pegawai = new MutableLiveData<>();
        apiService.getJumlahPegawai().enqueue(new Callback<ResponseGetJumlahPegawai>() {
            @Override
            public void onResponse(Call<ResponseGetJumlahPegawai> call, Response<ResponseGetJumlahPegawai> response) {
                if (cek(response.code())) {
                    if (response.body().getData() != null) {
                        if (response.body().getData().size() > 0) {
                            JumlahPegawaiModel model = response.body().getData().get(0);
                            pegawai.setValue(model);
                        } else {
                            pegawai.setValue(null);
                        }
                    } else {
                        pegawai.setValue(null);
                    }
                } else {
                    pegawai.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetJumlahPegawai> call, Throwable t) {
                pegawai.setValue(null);
            }
        });
        return pegawai;
    }

}
