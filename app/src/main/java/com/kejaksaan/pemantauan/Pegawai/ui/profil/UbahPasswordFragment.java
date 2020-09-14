package com.kejaksaan.pemantauan.Pegawai.ui.profil;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.Pegawai.PegawaiActivity;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.auth.LoginUser;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.databinding.UbahPasswordFragmentBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.serialize.req.RequestPostUpdatepassword;

import static com.kejaksaan.pemantauan.core.Utility.hideKeyboard;

public class UbahPasswordFragment extends Fragment {

    private UbahPasswordViewModel mViewModel;
    private UbahPasswordFragmentBinding binding;
    private AlertDialog.Builder builder;

    public static UbahPasswordFragment newInstance() {
        return new UbahPasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.ubah_password_fragment, container, false);
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Info");
        builder.create();
        mViewModel = new ViewModelProvider(this, new VMFactory(new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(@NonNull String message) {
                builder.setMessage("Berhasil Merubah Password, Silahkan Masuk Kembali");
                builder.setCancelable(false);
                builder.setPositiveButton("Ke Login", (dialog, which) -> {
                    getContext().startActivity(new Intent(getContext(), LoginUser.class));
                    getActivity().finish();
                });
                builder.show();

            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();

            }
        })).get(UbahPasswordViewModel.class);
        binding.btnSimpan.setOnClickListener(v -> {
            if (validasi()) {
                RequestPostUpdatepassword requestPostUpdatepassword = new RequestPostUpdatepassword();
                requestPostUpdatepassword.setId(MyUser.getInstance(getContext()).getUser().getId());
                requestPostUpdatepassword.setPassword(binding.etOldpass.getText().toString());
                requestPostUpdatepassword.setNewpassword(binding.etNnewpass.getText().toString());
                mViewModel.proses(requestPostUpdatepassword);
                hideKeyboard(getActivity());
            }
        });
        return binding.getRoot();

    }

    private boolean validasi() {

        boolean cek = !TextUtils.isEmpty(binding.etOldpass.getText().toString()) && !TextUtils.isEmpty(binding.etNnewpass.getText().toString());
        boolean cek2 = binding.etOldpass.getText().equals(binding.etNnewpass.getText().toString());
        if (cek) {
            if (cek2) {
                Snackbar.make(binding.getRoot(), "Password Baru Tidak Boleh Sama Dengan Password Lama", BaseTransientBottomBar.LENGTH_LONG).show();
            } else {
                Snackbar.make(binding.getRoot(), "Isi Semua Field!", BaseTransientBottomBar.LENGTH_LONG).show();
            }
        }
        return cek && !cek2;
    }


}