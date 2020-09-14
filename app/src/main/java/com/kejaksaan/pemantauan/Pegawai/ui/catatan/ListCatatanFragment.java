package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.core.callback.AdapterMenuClicked;
import com.kejaksaan.pemantauan.databinding.ListCatatanBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.CatatanModel;

import java.util.List;

public class ListCatatanFragment extends Fragment {

    private ListCatatanViewModel mViewModel;
    private ListCatatanBinding binding;
    private AdapterListCatatan adapterListCatatan;
    private AlertDialog.Builder builder;

    public static ListCatatanFragment newInstance() {
        return new ListCatatanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.list_catatan, container, false);
        mViewModel = new ViewModelProvider(this, new VMFactory(getContext(), new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_INDEFINITE).show();

            }

            @Override
            public void onSuccess(@NonNull String message) {

                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                mViewModel.getCatatan();
                observe(mViewModel);
            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();

            }
        })).get(ListCatatanViewModel.class);
        builder = new AlertDialog.Builder(getContext());
        builder.create();
        builder.setTitle("Info");
        adapterListCatatan = new AdapterListCatatan(new AdapterMenuClicked() {
            @Override
            public void onEdit(int posisi) {
                CatatanModel catatanModel = adapterListCatatan.getFromPos(posisi);
                builder.setMessage("Edit Catatan " + catatanModel.getJudul() + " ?");
                builder.setPositiveButton("Edit", (dialog, which) -> {
                    MyUser.getInstance(getContext()).setLastCatatan(catatanModel);
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_tambahcatatan);
                });
                builder.setNegativeButton("Batal", (dialog, which) -> {
                    dialog.cancel();
                });
                builder.show();
            }

            @Override
            public void onDelete(int posisi) {
                CatatanModel catatanModel = adapterListCatatan.getFromPos(posisi);
                builder.setMessage("Hapus Catatan " + catatanModel.getJudul() + " ?");
                builder.setPositiveButton("Hapus", (dialog, which) -> {
                    mViewModel.hapus(catatanModel);
                });
                builder.setNegativeButton("Batal", (dialog, which) -> {
                    dialog.cancel();
                });
                builder.show();
            }

            @Override
            public void onDetail(int posisi) {
                CatatanModel catatanModel = adapterListCatatan.getFromPos(posisi);
                MyUser.getInstance(getContext()).setLastCatatan(catatanModel);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_detailcatatan);
            }
        });

        binding.add.setOnClickListener(v -> {
            MyUser.getInstance(getContext()).setLastCatatan(null);
            Navigation.findNavController(binding.getRoot()).navigate(R.id.nav_tambahcatatan);
        });

        binding.rv.setAdapter(adapterListCatatan);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        observe(mViewModel);
    }

    private void observe(ListCatatanViewModel mViewModel) {
        mViewModel.getCatatan().observe(getViewLifecycleOwner(), catatanModels -> {
            if (catatanModels != null) {
                binding.rv.setVisibility(View.VISIBLE);
                binding.lyKosong.setVisibility(View.GONE);
                adapterListCatatan.setdata(catatanModels);
            } else {
                binding.rv.setVisibility(View.GONE);
                binding.lyKosong.setVisibility(View.VISIBLE);
            }

        });
    }
}