package com.kejaksaan.pemantauan.admin.ui.tambah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.home.DaftarPegawai;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.databinding.ActivityTambahPegawaiBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostUpdateProfil;

import static com.kejaksaan.pemantauan.core.Utility.hideKeyboard;

public class TambahPegawaiActivity extends AppCompatActivity {
    private ActivityTambahPegawaiBinding binding;
    private TambahPegawaiViewModel viewModel;
    private boolean isEdit = false;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tambah_pegawai);
        viewModel = new ViewModelProvider(this, new VMFactory(new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
                RESET();
                onBackPressed();
                finish();
            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        })).get(TambahPegawaiViewModel.class);
        builder = new AlertDialog.Builder(this);
        builder.create();
        getSupportActionBar().setTitle("Tambah Pegawai");
        if (MyUser.getInstance(TambahPegawaiActivity.this).getLastegawai() != null) {
            this.isEdit = true;
            setView();
            getSupportActionBar().setTitle("Edit Pegawai");
        }
        onClick();

    }

    private void RESET() {
        binding.etNRP.setText("");
        binding.etNIP.setText("");
        binding.etTmt.setText("");
        binding.etPassword.setText("");
        binding.etNohp.setText("");
        binding.etNama.setText("");
        binding.etJabatan.setText("");
        binding.etGolongan.setText("");
        binding.etAlamat.setText("");
    }


    private void onClick() {
        binding.btnBatal.setOnClickListener(v -> {
            if (masihEdit()) {
                builder.setTitle("Info");
                builder.setMessage("Perubahan belum disimpan, Tetap Batal ?");
                builder.setPositiveButton("Keluar", (dialog, which) -> finish());
                builder.setNegativeButton("Lanjutkan", (dialog, which) -> dialog.cancel());
                builder.show();

            } else {
                finish();
            }
        });
        binding.btnSimpan.setOnClickListener(v -> {
            hideKeyboard(this);
            if (validasi()) {
                if (binding.etNRP.getText().length() < 6) {
                    Snackbar.make(binding.getRoot(), "NRP harus lebih dari 6 karakter !", BaseTransientBottomBar.LENGTH_LONG).show();
                } else if (binding.etNIP.getText().length() < 4 || binding.etNIP.getText().length() > 30) {
                    Snackbar.make(binding.getRoot(), "NIP harus minimal 4 dan maksimal 30 karakter !", BaseTransientBottomBar.LENGTH_LONG).show();
                } else {
                    RadioButton level = findViewById(binding.radioGroup.getCheckedRadioButtonId());
                    builder.setTitle("Info");
                    builder.setMessage("Pastikan data sudah sesuai , Lanjutkan simpan ?");
                    builder.setNegativeButton("Batal", (dialog, which) -> dialog.cancel());
                    builder.setPositiveButton("Simpan", (dialog, which) -> {
                        UserModel u = new UserModel();
                        u.setAlamatTinggal(binding.etAlamat.getText().toString());
                        u.setGolonganPangkat(binding.etGolongan.getText().toString());
                        u.setJabatan(binding.etJabatan.getText().toString());
                        u.setLevel(level.getTag().toString());
                        u.setNamaLengkap(binding.etNama.getText().toString());
                        u.setNip(binding.etNIP.getText().toString());
                        u.setNoHp(binding.etNohp.getText().toString());
                        u.setNrp(binding.etNRP.getText().toString());
                        u.setPassword(binding.etPassword.getText().toString());
                        u.setTmt(binding.etTmt.getText().toString());

                        if (this.isEdit) {
                            u.setId(MyUser.getInstance(this).getLastegawai().getId());

                            viewModel.ubah(u);
                        } else {
                            u.setId("");
                            viewModel.simpan(u);
                        }

                    });
                    builder.show();
                }
            } else {
                builder.setTitle("Info");
                builder.setMessage("Mohon isi semua data !");
                builder.setNegativeButton("Oke", (dialog, which) -> dialog.cancel());
                builder.show();
            }
        });
    }


    private void setView() {
        binding.etNIP.setEnabled(true);
        binding.etPassword.setEnabled(false);

        PegawaiModel model = MyUser.getInstance(this).getLastegawai();
        binding.etNIP.setText(model.getNip());
        binding.etNRP.setText(model.getNrp());
        binding.etAlamat.setText(model.getAlamatTinggal());
        binding.etGolongan.setText(model.getGolonganPangkat());
        binding.etJabatan.setText(model.getJabatan());
        binding.etNama.setText(model.getNamaLengkap());
        binding.etNohp.setText(model.getNoHp());
        binding.etTmt.setText(model.getTmt());
        if (model.getLevel().equalsIgnoreCase("ADMIN")) {
            binding.radioButton2.setChecked(true);
        } else {
            binding.radioButton1.setChecked(true);
        }
    }

    private boolean validasi() {
        if (this.isEdit) {
            return !TextUtils.isEmpty(binding.etNIP.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNRP.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNama.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etAlamat.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etGolongan.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etJabatan.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNohp.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etTmt.getText().toString());
        } else {
            return !TextUtils.isEmpty(binding.etNIP.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNRP.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNama.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etAlamat.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etGolongan.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etJabatan.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etNohp.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etPassword.getText().toString()) &&
                    !TextUtils.isEmpty(binding.etTmt.getText().toString());
        }
    }

    private boolean masihEdit() {
        if (this.isEdit) {
            return !TextUtils.isEmpty(binding.etNIP.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNRP.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNama.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etAlamat.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etGolongan.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etJabatan.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNohp.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etTmt.getText().toString());
        } else {
            return !TextUtils.isEmpty(binding.etNIP.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNRP.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNama.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etAlamat.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etGolongan.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etJabatan.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etNohp.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etPassword.getText().toString()) ||
                    !TextUtils.isEmpty(binding.etTmt.getText().toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyUser.getInstance(this).setLastPegawai(null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyUser.getInstance(this).setLastPegawai(null);
    }

    @Override
    public void onBackPressed() {
        if (masihEdit()) {
            builder.setTitle("Info");
            builder.setMessage("Perubahan belum disimpan, Tetap Batal ?");
            builder.setPositiveButton("Keluar", (dialog, which) -> {
                startActivity(new Intent(TambahPegawaiActivity.this, DaftarPegawai.class));
                finish();
            });
            builder.setNegativeButton("Lanjutkan", (dialog, which) -> dialog.cancel());
            builder.show();
        } else {
            super.onBackPressed();
        }

    }
}