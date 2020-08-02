package com.kejaksaan.pemantauan.admin.ui.tambah;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentTambahPegawaiBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahPegawaiFragment extends Fragment {
    private FragmentTambahPegawaiBinding binding;

    public TambahPegawaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_tambah_pegawai, container, false);
        return binding.getRoot();
    }
}
