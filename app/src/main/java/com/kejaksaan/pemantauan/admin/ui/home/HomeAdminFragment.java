package com.kejaksaan.pemantauan.admin.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.AdminActivity;
import com.kejaksaan.pemantauan.databinding.FragmentHomeAdminBinding;
import com.tdn.domain.model.JumlahBelumMasukModel;
import com.tdn.domain.model.JumlahMasukModel;
import com.tdn.domain.model.JumlahPegawaiModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeAdminFragment extends Fragment {
    private FragmentHomeAdminBinding binding;
    private HomeAdminViewModel viewModel;

    public HomeAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home_admin, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(HomeAdminViewModel.class);
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        binding.btnJumlahpegawai.setOnClickListener(v -> startActivity(new Intent(requireContext(), DaftarPegawai.class)));
        binding.btnJumlahlaporan.setOnClickListener(v -> startActivity(new Intent(requireContext(), ListLaporanActivity.class)));
        binding.btnJumlahabsensi.setOnClickListener(v -> startActivity(new Intent(requireContext(), ListPresensi.class)));
    }

    @Override
    public void onResume() {
        super.onResume();
        observe(viewModel);
    }

    private void observe(HomeAdminViewModel viewModel) {
        viewModel.getJumlahPegawai().observe(getViewLifecycleOwner(), jumlahPegawaiModel -> {
            if (jumlahPegawaiModel != null) {
                binding.tvJumlahPegawai.setText("Jumlah  : " + jumlahPegawaiModel.getJumlah());
            }
        });
        viewModel.getJumlahMasuk().observe(getViewLifecycleOwner(), jumlahMasukModel -> {
            if (jumlahMasukModel != null) {
                binding.tvJumlahabsensi.setText("Jumlah : " + jumlahMasukModel.getJumlah());
            }
        });
        viewModel.getJumlahBelumMasuk().observe(getViewLifecycleOwner(), jumlahBelumMasukModel -> {
            if (jumlahBelumMasukModel != null) {
                binding.tvJumlahbelumpresensi.setText("Jumlah : " + jumlahBelumMasukModel.getJumlah());
            }

        });
    }
}
