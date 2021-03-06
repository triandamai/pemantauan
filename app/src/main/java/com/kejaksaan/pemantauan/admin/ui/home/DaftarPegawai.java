package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.tambah.TambahPegawaiActivity;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AdapterClicked;
import com.kejaksaan.pemantauan.core.callback.AdapterMenuClicked;
import com.kejaksaan.pemantauan.databinding.ActivityDaftarPegawaiBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.PegawaiModel;

import java.util.List;

public class DaftarPegawai extends AppCompatActivity {
    private AdapterListPegawai adapterListPegawai;
    private ActivityDaftarPegawaiBinding binding;
    private DaftarPegawaiViewModel viewModel;
    private AlertDialog.Builder a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar_pegawai);
        getSupportActionBar().setTitle("Daftar Pegawai");
        a = new AlertDialog.Builder(DaftarPegawai.this).setTitle("Info");
        a.create();
        viewModel = new ViewModelProvider(this, new VMFactory(new ActionListener() {
            @Override
            public void onStart() {
                Snackbar
                        .make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onSuccess(@NonNull String message) {
                Snackbar
                        .make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
                viewModel.getPegawai();
                observe(viewModel);


            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar
                        .make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        })).get(DaftarPegawaiViewModel.class);

        adapterListPegawai = new AdapterListPegawai(new AdapterMenuClicked() {
            @Override
            public void onEdit(int posisi) {
                PegawaiModel pegawaiModel = adapterListPegawai.getfromPos(posisi);
                MyUser.getInstance(DaftarPegawai.this).setLastPegawai(pegawaiModel);
                a.setMessage("Apakah anda yakin merubah pegawai " + pegawaiModel.getNamaLengkap() + " ?");
                a.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());
                a.setPositiveButton("Yakin", (dialog, which) -> {
                    startActivity(new Intent(DaftarPegawai.this, TambahPegawaiActivity.class));
                });
                a.show();
            }

            @Override
            public void onDelete(int posisi) {
                PegawaiModel pegawaiModel = adapterListPegawai.getfromPos(posisi);
                a.setMessage("Apakah anda yakin menghapus pegawai " + pegawaiModel.getNamaLengkap() + " ?");
                a.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());
                a.setPositiveButton("Yakin", (dialog, which) -> {
                    viewModel.delete(pegawaiModel.getId());
                });
                a.show();
            }

            @Override
            public void onDetail(int posisi) {
                PegawaiModel pegawaiModel = adapterListPegawai.getfromPos(posisi);
                MyUser.getInstance(DaftarPegawai.this).setLastPegawai(pegawaiModel);
                startActivity(new Intent(DaftarPegawai.this, TambahPegawaiActivity.class));
            }
        });
        binding.add.setOnClickListener(v -> {
            a.setMessage("Tambah Pegawai baru ?");
            a.setNegativeButton("Batal", (dialog, which) -> {
                dialog.cancel();
            });
            a.setPositiveButton("Tambah", (dialog, which) -> {
                startActivity(new Intent(DaftarPegawai.this, TambahPegawaiActivity.class));
            });
            a.show();

        });

        binding.swipe.setOnRefreshListener(() -> {
            viewModel.getPegawai();
            observe(viewModel);
            binding.swipe.setRefreshing(false);
        });
        binding.rv.setAdapter(adapterListPegawai);
        viewModel.getPegawai();
        observe(viewModel);

    }

    private void observe(DaftarPegawaiViewModel viewModel) {
        viewModel.getPegawai().observe(this, pegawaiModels -> {
            if (pegawaiModels != null) {
                binding.rv.setVisibility(View.VISIBLE);
                binding.lyKosong.setVisibility(View.GONE);
                adapterListPegawai.setdata(pegawaiModels);
            } else {
                binding.lyKosong.setVisibility(View.VISIBLE);
                binding.rv.setVisibility(View.GONE);
            }
        });
    }
}