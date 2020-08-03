package com.kejaksaan.pemantauan.core.callback;

import androidx.annotation.NonNull;

public interface ActionListener {
    void onStart();

    void onSuccess(@NonNull String message);

    void onError(@NonNull String message);
}
