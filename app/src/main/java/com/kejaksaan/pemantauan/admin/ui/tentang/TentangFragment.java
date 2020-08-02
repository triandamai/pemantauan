package com.kejaksaan.pemantauan.admin.ui.tentang;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentTentangBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TentangFragment extends Fragment {
    private FragmentTentangBinding binding;

    public TentangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_tentang, container, false);
        return binding.getRoot();
    }
}
