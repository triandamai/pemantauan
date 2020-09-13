package com.kejaksaan.pemantauan.Pegawai.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.kejaksaan.pemantauan.Pegawai.ui.laporan.ListLaporanPegawaiActivity;
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
      
        binding.btnUbahprofil.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_gallery);
        });
        binding.btnLaporan.setOnClickListener(v -> {
                    getContext().startActivity(new Intent(getContext(), ListLaporanPegawaiActivity.class));

                }
        );
        binding.btnCatatan.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_listcatatan);
        });
        return binding.getRoot();
    }
}
