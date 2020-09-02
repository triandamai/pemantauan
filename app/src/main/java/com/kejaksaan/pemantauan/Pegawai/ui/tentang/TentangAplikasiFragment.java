package com.kejaksaan.pemantauan.Pegawai.ui.tentang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentSlideshowBinding;

public class TentangAplikasiFragment extends Fragment {

    private TentangAplikasiViewModel tentangAplikasiViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tentangAplikasiViewModel = new
                ViewModelProvider(this).get(TentangAplikasiViewModel.class);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_slideshow, container, false);

        return binding.getRoot();
    }
}
