package com.kejaksaan.pemantauan.admin.ui.tambah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityTambahPegawaiBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.PegawaiModel;

public class TambahPegawaiActivity extends AppCompatActivity {
    private ActivityTambahPegawaiBinding binding;
    private TambahPegawaiViewModel viewModel;
    private boolean isEdit = false;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tambah_pegawai);
        builder = new AlertDialog.Builder(this);
        builder.create();

        if (MyUser.getInstance(TambahPegawaiActivity.this).getLastegawai() != null) {
            this.isEdit = true;
            setView();
        }
        onClick();

    }


    private void onClick() {
        binding.btnBatal.setOnClickListener(v -> {
            if (masihEdit()) {
                builder.setTitle("Info");
                builder.setMessage("Perubahan belum disimpan, Tetap Batal ?");
                builder.setPositiveButton("Batalkan", (dialog, which) -> finish());
                builder.setNegativeButton("Teruskan", (dialog, which) -> dialog.cancel());
                builder.show();

            } else {
                finish();
            }
        });
        binding.btnSimpan.setOnClickListener(v -> {
            if (validasi()) {
                builder.setTitle("Info");
                builder.setMessage("Pastikan data sudah sesuai !, Lanjutkan simpan ?");
                builder.setPositiveButton("Batal", (dialog, which) -> finish());
                builder.setNegativeButton("Simpan", (dialog, which) -> dialog.cancel());
                builder.show();
            } else {
                builder.setTitle("Info");
                builder.setMessage("Mohon isi semua data !");
                ;
                builder.setNegativeButton("Oke", (dialog, which) -> dialog.cancel());
                builder.show();
            }
        });
    }

    private void setView() {
        binding.etNIP.setEnabled(false);
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
}