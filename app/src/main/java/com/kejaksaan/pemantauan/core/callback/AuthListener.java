package com.kejaksaan.pemantauan.core.callback;

import androidx.annotation.NonNull;

import com.tdn.domain.model.UserModel;

public interface AuthListener {
    void onStart();

    void onSuccess(@NonNull String message, UserModel data);

    void onError(@NonNull String message);
}
