package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.common.api.Api;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.LaporanModel;
import com.tdn.domain.serialize.res.ResponseGetLaporan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class ListLaporanViewModel extends ViewModel {
    private ApiService apiService;

    public ListLaporanViewModel() {
        this.apiService = ApiService.Factory.create();
        getLaporan();
    }

    public LiveData<List<LaporanModel>> getLaporan() {
        final MutableLiveData<List<LaporanModel>> data = new MutableLiveData<>();
        apiService.getLaporan().enqueue(new Callback<ResponseGetLaporan>() {
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
}
