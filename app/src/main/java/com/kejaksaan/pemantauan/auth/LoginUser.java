package com.kejaksaan.pemantauan.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.Pegawai.PegawaiActivity;
import com.kejaksaan.pemantauan.admin.AdminActivity;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.SplashScreen;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.AuthListener;
import com.kejaksaan.pemantauan.databinding.ActivityLoginUserBinding;
import com.tdn.data.persistensi.MyUser;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostLogin;

public class LoginUser extends AppCompatActivity {
    private ActivityLoginUserBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_user);
        loginViewModel = new ViewModelProvider(this, new VMFactory(authListener)).get(LoginViewModel.class);

        binding.btnLogin.setOnClickListener(v -> {
            RequestPostLogin req = new RequestPostLogin();
            req.setNrp(binding.etUsernama.getText().toString());
            req.setPassword(binding.etPassword.getText().toString());
            loginViewModel.login(req);
        });

    }

    private AuthListener authListener = new AuthListener() {
        @Override
        public void onStart() {
            Snackbar.make(binding.getRoot(), "Proses..", BaseTransientBottomBar.LENGTH_LONG).show();
        }

        @Override
        public void onSuccess(@NonNull String message, UserModel data) {
            Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
            MyUser.getInstance(LoginUser.this).setUser(data);
            new Handler().postDelayed(() -> {
                if (data.getLevel().equals("ADMIN")) {
                    Intent i = new Intent(LoginUser.this, AdminActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(LoginUser.this, PegawaiActivity.class);
                    startActivity(i);
                }
            }, 1000);

        }

        @Override
        public void onError(@NonNull String message) {
            Snackbar.make(binding.getRoot(), message, BaseTransientBottomBar.LENGTH_LONG).show();
        }
    };
}
