package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;

public class TambahCatatanFragment extends Fragment {

    private TambahCatatanViewModel mViewModel;

    public static TambahCatatanFragment newInstance() {
        return new TambahCatatanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tambah_catatan_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TambahCatatanViewModel.class);
        // TODO: Use the ViewModel
    }

}