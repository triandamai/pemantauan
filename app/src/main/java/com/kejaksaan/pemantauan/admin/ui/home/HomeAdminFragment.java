package com.kejaksaan.pemantauan.admin.ui.home;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentHomeAdminBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeAdminFragment extends Fragment {
    private FragmentHomeAdminBinding binding;

    public HomeAdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home_admin, container, false);
        return binding.getRoot();
    }
}
