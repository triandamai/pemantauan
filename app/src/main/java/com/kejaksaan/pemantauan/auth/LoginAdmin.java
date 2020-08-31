package com.kejaksaan.pemantauan.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.AdminActivity;

public class LoginAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        Button login = findViewById(R.id.btnLogin);
        login.setOnClickListener(v -> {
            Intent i = new Intent(LoginAdmin.this, AdminActivity.class);
            startActivity(i);
        });
    }
}
