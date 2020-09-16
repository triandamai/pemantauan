package com.kejaksaan.pemantauan.Pegawai.ui.profil;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AuthListener;
import com.kejaksaan.pemantauan.databinding.FragmentUbahprofilBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostUpdateProfil;

import org.w3c.dom.Text;

public class UbahProfilFragment extends Fragment {

    private UbahProfilViewModel ubahProfilViewModel;
    private FragmentUbahprofilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_ubahprofil, container, false);
        UserModel u2 = MyUser.getInstance(getContext()).getUser();
        binding.tvNip.setText(u2.getNip());
        binding.tvNrp.setText(u2.getNrp());
        binding.etAlamat.setText(u2.getAlamatTinggal());
        binding.etGolongan.setText(u2.getGolonganPangkat());
        binding.etJabatan.setText(u2.getJabatan());
        binding.etNamaPegawai.setText(u2.getNamaLengkap());
        binding.etNohp.setText(u2.getNoHp());
        binding.etTmt.setText(u2.getTmt());

        ubahProfilViewModel = new ViewModelProvider(this, new VMFactory(getContext(), new AuthListener() {
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses...", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onSuccess(@NonNull String message, UserModel u) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
                MyUser.getInstance(getContext()).setUser(u);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_home);
            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        })).get(UbahProfilViewModel.class);
        binding.btnSimpan.setOnClickListener(v -> {
            if (cekValidasi()) {
                RequestPostUpdateProfil req = new RequestPostUpdateProfil();
                UserModel u = MyUser.getInstance(getContext()).getUser();
                UserModel updatedUser = new UserModel();
                req.setId(u.getId());
                req.setAlamatTinggal(binding.etAlamat.getText().toString());
                req.setGolonganPangkat(binding.etGolongan.getText().toString());
                req.setJabatan(binding.etJabatan.getText().toString());
                req.setNamaLengkap(binding.etNamaPegawai.getText().toString());
                req.setNoHp(binding.etNohp.getText().toString());
                req.setTmt(binding.etTmt.getText().toString());

                updatedUser.setId(u.getId());
                updatedUser.setAlamatTinggal(binding.etAlamat.getText().toString());
                updatedUser.setGolonganPangkat(binding.etGolongan.getText().toString());
                updatedUser.setJabatan(binding.etJabatan.getText().toString());
                updatedUser.setNamaLengkap(binding.etNamaPegawai.getText().toString());
                updatedUser.setNoHp(binding.etNohp.getText().toString());
                updatedUser.setTmt(binding.etTmt.getText().toString());
                updatedUser.setLevel(u.getLevel());
                updatedUser.setNip(u.getNip());
                updatedUser.setNrp(u.getNrp());
                updatedUser.setPassword(u.getPassword());

                ubahProfilViewModel.ubah(req, updatedUser);
            }

        });
        return binding.getRoot();
    }

    private boolean cekValidasi() {
        boolean cek = !TextUtils.isEmpty(binding.etAlamat.getText().toString()) ||
                !TextUtils.isEmpty(binding.etGolongan.getText().toString()) ||
                !TextUtils.isEmpty(binding.etJabatan.getText().toString()) ||
                !TextUtils.isEmpty(binding.etNamaPegawai.getText().toString()) ||
                !TextUtils.isEmpty(binding.etNohp.getText().toString()) ||
                !TextUtils.isEmpty(binding.etTmt.getText().toString());
        if (!cek) {
            Snackbar.make(binding.getRoot(), "Semua tidak boleh kosong!", BaseTransientBottomBar.LENGTH_LONG).show();
        }
        return cek;
    }
}
