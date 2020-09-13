package com.kejaksaan.pemantauan.admin.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tdn.data.service.ApiService;
import com.tdn.domain.model.JumlahMasukModel;
import com.tdn.domain.model.JumlahBelumMasukModel;
import com.tdn.domain.model.JumlahPegawaiModel;
import com.tdn.domain.model.LaporanModel;
import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.serialize.res.ResponseGetJumlahBelumMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahMasuk;
import com.tdn.domain.serialize.res.ResponseGetJumlahPegawai;
import com.tdn.domain.serialize.res.ResponseGetLaporan;
import com.tdn.domain.serialize.res.ResponseGetLokasi;
import com.tdn.domain.serialize.res.ResponseGetPegawai;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class HomeAdminViewModel extends ViewModel {
    private ApiService apiService;
    private ApiService service2;

    public HomeAdminViewModel() {
        this.apiService = ApiService.GatsuFactory.create();
        this.service2 = ApiService.Factory.create();
        getJumlahMasuk();
        getJumlahPegawai();
        getJumlahBelumMasuk();
        getLaporan();
        getPegawai();
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

    public LiveData<List<LaporanModel>> getLaporan() {
        final MutableLiveData<List<LaporanModel>> data = new MutableLiveData<>();
        service2.getLaporan("").enqueue(new Callback<ResponseGetLaporan>() {
            @Override
            public void onResponse(Call<ResponseGetLaporan> call, Response<ResponseGetLaporan> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            List<LaporanModel> list = response.body().getData();
                            data.setValue(list);
                        } else {
                            data.setValue(null);
                        }
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetLaporan> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public LiveData<List<PegawaiModel>> getPegawai() {
        final MutableLiveData<List<PegawaiModel>> data = new MutableLiveData<>();
        service2.getPegawai().enqueue(new Callback<ResponseGetPegawai>() {
            @Override
            public void onResponse(Call<ResponseGetPegawai> call, Response<ResponseGetPegawai> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            List<PegawaiModel> list = response.body().getData();
                            data.setValue(list);
                        } else {
                            data.setValue(null);
                        }
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseGetPegawai> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
