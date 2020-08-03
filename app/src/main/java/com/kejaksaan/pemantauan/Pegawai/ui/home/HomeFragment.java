package com.kejaksaan.pemantauan.Pegawai.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentHomeBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.UserModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new
                ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home, container, false);
        UserModel userModel = MyUser.getInstance(getContext()).getUser();
        binding.nip.setText(userModel.getNip());
        binding.alamatTinggal.setText(userModel.getAlamatTinggal());
        binding.golongan.setText(userModel.getGolonganPangkat());
        binding.jabatan.setText(userModel.getJabatan());
        binding.namaPegawai.setText(userModel.getNamaLengkap());
        binding.noHP.setText(userModel.getNoHp());
        binding.nrp.setText(userModel.getNrp());
        binding.tmt.setText(userModel.getTmt());
        return binding.getRoot();
    }
}
