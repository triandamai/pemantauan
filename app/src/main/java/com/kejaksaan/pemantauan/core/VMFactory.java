package com.kejaksaan.pemantauan.core;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kejaksaan.pemantauan.admin.ui.tambah.TambahPegawaiViewModel;
import com.kejaksaan.pemantauan.auth.LoginViewModel;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AuthListener;


public class VMFactory implements ViewModelProvider.Factory {
    private Context context;
    private String id = "";
    private ActionListener actionListener;
    private AuthListener authListener;

    public VMFactory(@NonNull Context context) {
        this.context = context;
    }

    public VMFactory(@NonNull AuthListener context) {
        this.authListener = context;
    }

    public VMFactory(@NonNull ActionListener context) {
        this.actionListener = context;
    }

    public VMFactory(@NonNull Context context, ActionListener actionListener) {
        this.context = context;
        this.actionListener = actionListener;
    }

    public VMFactory(@NonNull Context context, AuthListener actionListener) {
        this.context = context;
        this.authListener = actionListener;
    }

    public VMFactory(@NonNull Context context, ActionListener actionListener, String id) {
        this.context = context;
        this.actionListener = actionListener;
        this.id = id;
    }


    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(authListener);
        } else if (modelClass.isAssignableFrom(TambahPegawaiViewModel.class)) {
            return (T) new TambahPegawaiViewModel(actionListener);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }

    }
}
