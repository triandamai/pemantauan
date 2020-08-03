package com.kejaksaan.pemantauan.core.callback;

import androidx.annotation.NonNull;

import com.tdn.domain.model.UserModel;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public interface AuthListener {
    void onStart();

    void onSuccess(@NonNull String message, UserModel data);

    void onError(@NonNull String message);
}
