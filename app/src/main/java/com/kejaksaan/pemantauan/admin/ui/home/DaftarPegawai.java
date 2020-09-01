package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityDaftarPegawaiBinding;
import com.tdn.domain.model.PegawaiModel;

import java.util.List;

public class DaftarPegawai extends AppCompatActivity {
    private AdapterListPegawai adapterListPegawai;
    private ActivityDaftarPegawaiBinding binding;
    private DaftarPegawaiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar_pegawai);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Daftar Nama Pegawai");
        viewModel = new ViewModelProvider(this).get(DaftarPegawaiViewModel.class);
        adapterListPegawai = new AdapterListPegawai();
        binding.rv.setAdapter(adapterListPegawai);
        observe(viewModel);
    }

    private void observe(DaftarPegawaiViewModel viewModel) {
        viewModel.getPegawai().observe(this, pegawaiModels -> {
            if (pegawaiModels != null) {
                adapterListPegawai.setdata(pegawaiModels);
            }
        });
    }
}