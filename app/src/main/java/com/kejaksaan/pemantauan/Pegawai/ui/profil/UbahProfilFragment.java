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
        binding.tvAlamatTinggal.setText(u2.getAlamatTinggal());
        binding.tvGolongan.setText(u2.getGolonganPangkat());
        binding.tvJabatan.setText(u2.getJabatan());
        binding.tvNamaPegawai.setText(u2.getNamaLengkap());
        binding.tvNoHP.setText(u2.getNoHp());
        binding.tvTmt.setText(u2.getTmt());

        ubahProfilViewModel = new ViewModelProvider(this, new VMFactory(getContext(), new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses...", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onSuccess(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
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
                req.setId(u.getId());
                req.setAlamatTinggal(binding.tvAlamatTinggal.getText().toString());
                req.setGolonganPangkat(binding.tvGolongan.getText().toString());
                req.setJabatan(binding.tvJabatan.getText().toString());
                req.setNamaLengkap(binding.tvNamaPegawai.getText().toString());
                req.setNoHp(binding.tvNoHP.getText().toString());
                req.setTmt(binding.tvTmt.getText().toString());
                ubahProfilViewModel.ubah(req);
            }

        });
        return binding.getRoot();
    }

    private boolean cekValidasi() {
        boolean cek = !TextUtils.isEmpty(binding.tvAlamatTinggal.getText().toString()) ||
                !TextUtils.isEmpty(binding.tvGolongan.getText().toString()) ||
                !TextUtils.isEmpty(binding.tvJabatan.getText().toString()) ||
                !TextUtils.isEmpty(binding.tvNamaPegawai.getText().toString()) ||
                !TextUtils.isEmpty(binding.tvNoHP.getText().toString()) ||
                !TextUtils.isEmpty(binding.tvTmt.getText().toString());
        if (!cek) {
            Snackbar.make(binding.getRoot(), "Semua tidak boleh kosong!", BaseTransientBottomBar.LENGTH_LONG).show();
        }
        return cek;
    }
}
