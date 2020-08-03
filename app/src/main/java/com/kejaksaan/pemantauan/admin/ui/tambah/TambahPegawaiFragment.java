package com.kejaksaan.pemantauan.admin.ui.tambah;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.databinding.FragmentTambahPegawaiBinding;
import com.tdn.domain.model.UserModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahPegawaiFragment extends Fragment {
    private FragmentTambahPegawaiBinding binding;
    private TambahPegawaiViewModel viewModel;

    public TambahPegawaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_tambah_pegawai, container, false);
        viewModel = new ViewModelProvider(this, new VMFactory(actionListener)).get(TambahPegawaiViewModel.class);
        binding.btnSimpan.setOnClickListener(v -> {
            if (validasi()) {
                UserModel u = new UserModel();
                u.setAlamatTinggal(binding.alamatTinggal.getText().toString());
                u.setGolonganPangkat(binding.golongan.getText().toString());
                u.setId("");
                u.setJabatan(binding.jabatan.getText().toString());
                u.setLevel("USER");
                u.setNamaLengkap(binding.namaPegawai.getText().toString());
                u.setNip(binding.nip.getText().toString());
                u.setNoHp(binding.noHP.getText().toString());
                u.setNrp(binding.nrp.getText().toString());
                u.setPassword(binding.password.getText().toString());
                u.setTmt(binding.tmt.getText().toString());

                viewModel.simpan(u);
            } else {
                Snackbar.make(binding.getRoot(), "Mohon isi semua field..", BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });
        return binding.getRoot();
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void onStart() {
            Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_LONG).show();
        }

        @Override
        public void onSuccess(@NonNull String message) {
            Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
        }

        @Override
        public void onError(@NonNull String message) {
            Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
        }
    };

    private boolean validasi() {
        return !TextUtils.isEmpty(binding.alamatTinggal.getText().toString()) ||
                !TextUtils.isEmpty(binding.golongan.getText().toString()) ||
                !TextUtils.isEmpty(binding.jabatan.getText().toString()) ||
                !TextUtils.isEmpty(binding.namaPegawai.getText().toString()) ||
                !TextUtils.isEmpty(binding.nip.getText().toString()) ||
                !TextUtils.isEmpty(binding.noHP.getText().toString()) ||
                !TextUtils.isEmpty(binding.nrp.getText().toString()) ||
                !TextUtils.isEmpty(binding.password.getText().toString()) ||
                !TextUtils.isEmpty(binding.tmt.getText().toString());
    }
}
