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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new
                ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home, container, false);

        return binding.getRoot();
    }
}
