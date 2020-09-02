package com.kejaksaan.pemantauan.core;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kejaksaan.pemantauan.Pegawai.ui.home.TambahLaporanViewModel;
import com.kejaksaan.pemantauan.admin.ui.home.DaftarPegawai;
import com.kejaksaan.pemantauan.admin.ui.home.DaftarPegawaiViewModel;
import com.kejaksaan.pemantauan.admin.ui.tambah.TambahPegawaiViewModel;
import com.kejaksaan.pemantauan.auth.LoginViewModel;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AuthListener;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
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
        } else if (modelClass.isAssignableFrom(DaftarPegawaiViewModel.class)) {
            return (T) new DaftarPegawaiViewModel(actionListener);
        } else if (modelClass.isAssignableFrom(TambahLaporanViewModel.class)) {
            return (T) new TambahLaporanViewModel(context, actionListener);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }

    }
}
