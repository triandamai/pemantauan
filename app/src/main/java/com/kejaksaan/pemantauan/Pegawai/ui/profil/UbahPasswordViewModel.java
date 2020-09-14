package com.kejaksaan.pemantauan.Pegawai.ui.profil;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.serialize.req.RequestPostUpdatepassword;
import com.tdn.domain.serialize.res.ResponseAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class UbahPasswordViewModel extends ViewModel {
    private ApiService apiService;

    private ActionListener actionListener;

    public UbahPasswordViewModel(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.apiService = ApiService.Factory.create();
    }

    public void proses(RequestPostUpdatepassword requestPostUpdatepassword) {
        actionListener.onStart();
        apiService.ubahpassword(requestPostUpdatepassword)
                .enqueue(new Callback<ResponseAction>() {
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
    // TODO: Implement the ViewModel
}