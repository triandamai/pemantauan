package com.kejaksaan.pemantauan.Pegawai.ui.profil;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AuthListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostUpdateProfil;
import com.tdn.domain.serialize.res.ResponseAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class UbahProfilViewModel extends ViewModel {
    private ApiService apiService;
    private AuthListener actionListener;

    public UbahProfilViewModel(AuthListener actionListener) {
        this.apiService = ApiService.Factory.create();

        this.actionListener = actionListener;
    }

    public void ubah(RequestPostUpdateProfil req, UserModel u) {
        actionListener.onStart();

        apiService.ubahprofil(req).enqueue(new Callback<ResponseAction>() {
            @Override
            public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        actionListener.onSuccess(response.body().getResponseMessage(), u);
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