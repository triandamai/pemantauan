package com.kejaksaan.pemantauan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kejaksaan.pemantauan.Pegawai.PegawaiActivity;
import com.kejaksaan.pemantauan.admin.AdminActivity;
import com.kejaksaan.pemantauan.auth.LoginAdmin;
import com.kejaksaan.pemantauan.auth.LoginUser;
import com.tdn.data.persistensi.MyUser;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (MyUser.getInstance(SplashScreen.this).getUser() == null) {
            startActivity(new Intent(SplashScreen.this, LoginUser.class));
            finish();
        } else {
            if (MyUser.getInstance(SplashScreen.this).getUser().getLevel().equals("ADMIN")) {
                startActivity(new Intent(SplashScreen.this, AdminActivity.class));
                finish();
            } else {
                startActivity(new Intent(SplashScreen.this, PegawaiActivity.class));
                finish();
            }
        }
    }
}
