package com.kejaksaan.pemantauan.auth;

import android.widget.Adapter;

import androidx.lifecycle.ViewModel;

import com.kejaksaan.pemantauan.core.callback.AuthListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.serialize.req.RequestPostLogin;
import com.tdn.domain.serialize.res.ResponseAuthLogin;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class LoginViewModel extends ViewModel {
    private Realm realm;
    private AuthListener authListener;
    private ApiService apiService;

    public LoginViewModel(AuthListener authListener) {
        this.authListener = authListener;
        this.realm = Realm.getDefaultInstance();
        this.apiService = ApiService.Factory.create();
    }

    public void login(RequestPostLogin login) {
        authListener.onStart();
        apiService.login(login).enqueue(new Callback<ResponseAuthLogin>() {
            @Override
            public void onResponse(Call<ResponseAuthLogin> call, Response<ResponseAuthLogin> response) {
                if (cek(response.code())) {
                    if (cek(response.body().getResponseCode())) {
                        if (response.body().getData() != null) {
                            authListener.onSuccess(response.body().getResponseMessage(), response.body().getData().get(0));
                        } else {
                            authListener.onError(response.body().getResponseMessage());
                        }
                    } else {
                        authListener.onError(response.body().getResponseMessage());
                    }
                } else {
                    authListener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseAuthLogin> call, Throwable t) {
                authListener.onError(t.getMessage());
            }
        });
    }
}
