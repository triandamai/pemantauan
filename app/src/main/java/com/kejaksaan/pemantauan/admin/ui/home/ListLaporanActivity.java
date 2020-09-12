package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityListLaporanBinding;
import com.tdn.domain.model.LaporanModel;

import java.util.List;

public class ListLaporanActivity extends AppCompatActivity {
    private AdapterListLaporan adapterListLaporan;
    private ListLaporanViewModel viewModel;
    private ActivityListLaporanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_laporan);
//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setTitle("Daftar Laporan");
        viewModel = new ViewModelProvider(this).get(ListLaporanViewModel.class);
        adapterListLaporan = new AdapterListLaporan();
        binding.rv.setAdapter(adapterListLaporan);

        observe(viewModel);
    }

    private void observe(ListLaporanViewModel viewModel) {
        viewModel.getLaporan().observe(this, laporanModels -> {
            if (laporanModels != null) {
                adapterListLaporan.setdata(laporanModels);
            }
        });
    }
}