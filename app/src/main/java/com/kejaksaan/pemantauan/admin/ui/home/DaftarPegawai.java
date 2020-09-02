package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AdapterClicked;
import com.kejaksaan.pemantauan.databinding.ActivityDaftarPegawaiBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.PegawaiModel;

import java.util.List;

public class DaftarPegawai extends AppCompatActivity {
    private AdapterListPegawai adapterListPegawai;
    private ActivityDaftarPegawaiBinding binding;
    private DaftarPegawaiViewModel viewModel;
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_daftar_pegawai);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Daftar Nama Pegawai");
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

            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar
                        .make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        })).get(DaftarPegawaiViewModel.class);

        adapterListPegawai = new AdapterListPegawai(posisi -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.create();
            alertDialog.setTitle("Pegawai " + adapterListPegawai.getfromPos(posisi).getNamaLengkap());
            if (MyUser.getInstance(this).getUser().getLevel().equalsIgnoreCase(adapterListPegawai.getfromPos(posisi).getLevel())) {
                alertDialog.setMessage("Golongan : " + adapterListPegawai.getfromPos(posisi).getGolonganPangkat());
            } else {
                if (adapterListPegawai.getfromPos(posisi).getLevel().equalsIgnoreCase("USER")) {
                    ArrayUtils.appendToArray(items, "Ubah Menjadi Admin");
                } else {

                    ArrayUtils.appendToArray(items, "Ubah Menjadi User");
                }
            }

            alertDialog.setItems(items, (dialog, which) -> {
                viewModel.ubah(adapterListPegawai.getfromPos(posisi));
                dialog.dismiss();
            });
            alertDialog.setNegativeButton("BATAL", (dialog, which) -> {
                dialog.dismiss();
            });
            alertDialog.show();
        });
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