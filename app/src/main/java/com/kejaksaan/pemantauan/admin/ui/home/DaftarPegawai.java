package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityDaftarPegawaiBinding;

public class DaftarPegawai extends AppCompatActivity {
    private AdapterListPegawai adapterListPegawai;
    private ActivityDaftarPegawaiBinding binding;
    private DaftarPegawaiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar_pegawai);
        viewModel = new ViewModelProvider(this).get(DaftarPegawaiViewModel.class);
        adapterListPegawai = new AdapterListPegawai();
        binding.rv.setAdapter(adapterListPegawai);
        observe(viewModel);
    }

    private void observe(DaftarPegawaiViewModel viewModel) {

    }
}