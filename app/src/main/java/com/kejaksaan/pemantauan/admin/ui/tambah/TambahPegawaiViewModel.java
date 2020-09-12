package com.kejaksaan.pemantauan.admin.ui.tambah;

import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostUpdateProfil;
import com.tdn.domain.serialize.res.ResponseAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class TambahPegawaiViewModel extends ViewModel {
    private ActionListener actionListener;
    private ApiService apiService;

    public TambahPegawaiViewModel(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.apiService = ApiService.Factory.create();
    }

    public void simpan(UserModel u) {
        actionListener.onStart();
        apiService.register(u).enqueue(new Callback<ResponseAction>() {
            @Override
            public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            actionListener.onSuccess(response.body().getResponseMessage());
                        } else {
                            actionListener.onError(response.body().getResponseMessage());
                        }
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

    public void ubah(UserModel u) {
        actionListener.onStart();
        apiService.ubahpegawai(u).enqueue(new Callback<ResponseAction>() {
            @Override
            public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            actionListener.onSuccess(response.body().getResponseMessage());
                        } else {
                            actionListener.onError(response.body().getResponseMessage());
                        }
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
