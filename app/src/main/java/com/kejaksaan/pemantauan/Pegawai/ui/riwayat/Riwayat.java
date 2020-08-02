package com.kejaksaan.pemantauan.Pegawai.ui.riwayat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentRiwayatBinding;
import com.kejaksaan.pemantauan.databinding.FragmentSlideshowBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Riwayat extends Fragment {

    private RiwayatViewModel riwayatViewModel;
    private FragmentRiwayatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riwayatViewModel = new
                ViewModelProvider(this).get(RiwayatViewModel.class);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_riwayat, container, false);

        return binding.getRoot();
    }
}
