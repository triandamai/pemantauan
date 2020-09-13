package com.kejaksaan.pemantauan.Pegawai.ui.laporan;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.home.AdapterListLaporan;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.databinding.ActivityListLaporanBinding;

public class ListLaporanPegawaiActivity extends AppCompatActivity {
    private AdapterListLaporanPegawai adapterListLaporan;
    private ListLaporanPegawaiViewModel viewModel;
    private ActivityListLaporanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_laporan);

        viewModel = new ViewModelProvider(this, new VMFactory(this)).get(ListLaporanPegawaiViewModel.class);
        getSupportActionBar().setTitle("Daftar Laporan");
        adapterListLaporan = new AdapterListLaporanPegawai();
        binding.rv.setAdapter(adapterListLaporan);
        binding.swipe.setOnRefreshListener(() -> {
            viewModel.getLaporan();
            observe(viewModel);
            binding.swipe.setRefreshing(false);
        });
        viewModel.getLaporan();
        observe(viewModel);
    }

    private void observe(ListLaporanPegawaiViewModel viewModel) {
        viewModel.getLaporan().observe(this, laporanModels -> {
            Log.e("iniin", laporanModels.toString());
            if (laporanModels != null) {
                adapterListLaporan.setdata(laporanModels);
            }
        });
    }
}