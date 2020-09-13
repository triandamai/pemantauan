package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityListPresensiBinding;
import com.tdn.domain.model.AbsensiNama;

import java.util.List;

public class ListPresensi extends AppCompatActivity {
    private AdapterListPresensi adapterListPresensi;
    private ActivityListPresensiBinding binding;
    private ListPresensiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_presensi);
        getSupportActionBar().setTitle("Daftar Absensi pegawai");
        viewModel = new ViewModelProvider(this).get(ListPresensiViewModel.class);
        adapterListPresensi = new AdapterListPresensi();
        binding.rv.setAdapter(adapterListPresensi);
        observe(viewModel);
    }

    private void observe(ListPresensiViewModel viewModel) {
        viewModel.getPresensi().observe(this, absensiNamas -> {
            if (absensiNamas != null) {
                adapterListPresensi.setdata(absensiNamas);
            }
        });
    }

}