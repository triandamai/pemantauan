package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

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

        viewModel = new ViewModelProvider(this).get(ListLaporanViewModel.class);
        getSupportActionBar().setTitle("Daftar Laporan");
        adapterListLaporan = new AdapterListLaporan();
        binding.rv.setAdapter(adapterListLaporan);
        binding.swipe.setOnRefreshListener(() -> {
            viewModel.getLaporan();
            observe(viewModel);
            binding.swipe.setRefreshing(false);
        });
        viewModel.getLaporan();
        observe(viewModel);
    }

    private void observe(ListLaporanViewModel viewModel) {
        viewModel.getLaporan().observe(this, laporanModels -> {
            if (laporanModels != null) {
                binding.rv.setVisibility(View.VISIBLE);
                binding.lyKosong.setVisibility(View.GONE);
                adapterListLaporan.setdata(laporanModels);
            } else {
                binding.rv.setVisibility(View.GONE);
                binding.lyKosong.setVisibility(View.VISIBLE);
            }
        });
    }
}