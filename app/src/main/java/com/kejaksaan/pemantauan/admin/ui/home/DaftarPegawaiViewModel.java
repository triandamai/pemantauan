package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.res.ResponseAction;
import com.tdn.domain.serialize.res.ResponseGetPegawai;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class DaftarPegawaiViewModel extends ViewModel {
    private ApiService apiService;
    private ActionListener actionListener;

    public DaftarPegawaiViewModel(ActionListener actionListener) {
        this.apiService = ApiService.Factory.create();
        this.actionListener = actionListener;
        getPegawai();
    }

    public LiveData<List<PegawaiModel>> getPegawai() {
        final MutableLiveData<List<PegawaiModel>> data = new MutableLiveData<>();
        apiService.getPegawai().enqueue(new Callback<ResponseGetPegawai>() {
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

    public void ubah(PegawaiModel item) {
        actionListener.onStart();
        apiService.ubahlevel(item).enqueue(new Callback<ResponseAction>() {
            @Override
            public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        actionListener.onSuccess(response.body().getResponseMessage());
                    } else {
                        actionListener.onError(response.body().getResponseMessage());
                    }
                } else {
                    actionListener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseAction> call, Throwable t) {
                actionListener.onError(t.getMessage());
            }
        });
    }
}
