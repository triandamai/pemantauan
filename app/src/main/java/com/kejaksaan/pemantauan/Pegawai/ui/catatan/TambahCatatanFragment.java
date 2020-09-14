package com.kejaksaan.pemantauan.Pegawai.ui.catatan;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.databinding.TambahCatatanFragmentBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.serialize.req.RequestPostAddCatatan;

import static com.kejaksaan.pemantauan.core.Utility.hideKeyboard;

public class TambahCatatanFragment extends Fragment {

    private TambahCatatanViewModel mViewModel;
    private TambahCatatanFragmentBinding binding;
    private boolean isEdit = false;

    public static TambahCatatanFragment newInstance() {
        return new TambahCatatanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.tambah_catatan_fragment, container, false);
        mViewModel = new ViewModelProvider(this, new VMFactory(getContext(), new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                binding.btnSimpan.setEnabled(false);
            }

            @Override
            public void onSuccess(@NonNull String message) {
                binding.btnSimpan.setEnabled(true);
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                MyUser.getInstance(getContext()).setLastCatatan(null);
                Navigation.findNavController(binding.getRoot()).popBackStack();
            }

            @Override
            public void onError(@NonNull String message) {
                binding.btnSimpan.setEnabled(true);
                Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_INDEFINITE).show();

            }
        })).get(TambahCatatanViewModel.class);
        if (MyUser.getInstance(getContext()).getLastCatatan() != null) {
            isEdit = true;
            binding.etIsi.setText(MyUser.getInstance(getContext()).getLastCatatan().getIsi());
            binding.etJudul.setText(MyUser.getInstance(getContext()).getLastCatatan().getJudul());
        }
        binding.btnSimpan.setOnClickListener(v -> {
            if (validasi()) {
                hideKeyboard(getActivity());
                if (this.isEdit) {
                    RequestPostAddCatatan requestPostAddCatatan = new RequestPostAddCatatan();

                    requestPostAddCatatan.setIdCatatan(MyUser.getInstance(getContext()).getLastCatatan().getIdCatatan());
                    requestPostAddCatatan.setIdPegawai(MyUser.getInstance(getContext()).getUser().getId());
                    requestPostAddCatatan.setJudul(binding.etJudul.getText().toString());
                    requestPostAddCatatan.setIsi(binding.etIsi.getText().toString());
                    mViewModel.simpan(requestPostAddCatatan);
                } else {
                    RequestPostAddCatatan requestPostAddCatatan = new RequestPostAddCatatan();


                    requestPostAddCatatan.setIdCatatan("");
                    requestPostAddCatatan.setIdPegawai(MyUser.getInstance(getContext()).getUser().getId());
                    requestPostAddCatatan.setJudul(binding.etJudul.getText().toString());
                    requestPostAddCatatan.setIsi(binding.etIsi.getText().toString());
                    mViewModel.simpan(requestPostAddCatatan);
                }
            }
        });
        return binding.getRoot();
    }

    private boolean validasi() {
        boolean cek = !TextUtils.isEmpty(binding.etIsi.getText().toString()) && !TextUtils.isEmpty(binding.etJudul.getText().toString());
        if (!cek) {
            Snackbar.make(binding.getRoot(), "Isi semua field!", BaseTransientBottomBar.LENGTH_LONG).show();
        }
        return cek;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyUser.getInstance(getContext()).setLastCatatan(null);
    }
}