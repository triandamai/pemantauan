package com.kejaksaan.pemantauan.Pegawai.ui.slideshow;

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
import com.kejaksaan.pemantauan.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = new
                ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_slideshow, container, false);

        return binding.getRoot();
    }
}
