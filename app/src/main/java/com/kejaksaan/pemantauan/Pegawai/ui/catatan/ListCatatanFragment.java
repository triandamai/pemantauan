package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.callback.AdapterMenuClicked;
import com.kejaksaan.pemantauan.databinding.ListCatatanBinding;
import com.tdn.domain.model.CatatanModel;

import java.util.List;

public class ListCatatanFragment extends Fragment {

    private ListCatatanViewModel mViewModel;
    private ListCatatanBinding binding;
    private AdapterListCatatan adapterListCatatan;

    public static ListCatatanFragment newInstance() {
        return new ListCatatanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.list_catatan, container, false);
        mViewModel = new ViewModelProvider(this).get(ListCatatanViewModel.class);
        adapterListCatatan = new AdapterListCatatan(new AdapterMenuClicked() {
            @Override
            public void onEdit(int posisi) {

            }

            @Override
            public void onDelete(int posisi) {

            }

            @Override
            public void onDetail(int posisi) {

            }
        });
        binding.rv.setAdapter(adapterListCatatan);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        observe(mViewModel);
    }

    private void observe(ListCatatanViewModel mViewModel) {
        mViewModel.getCatatan().observe(getViewLifecycleOwner(), catatanModels -> {
            if (catatanModels != null) {
                adapterListCatatan.setdata(catatanModels);
            }

        });
    }
}