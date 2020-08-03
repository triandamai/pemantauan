package com.kejaksaan.pemantauan.core.callback;

import androidx.annotation.NonNull;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public interface ActionListener {
    void onStart();

    void onSuccess(@NonNull String message);

    void onError(@NonNull String message);
}
