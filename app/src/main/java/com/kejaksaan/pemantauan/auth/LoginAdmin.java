package com.kejaksaan.pemantauan.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.AdminActivity;

public class LoginAdmin extends AppCompatActivity {
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginAdmin.this, AdminActivity.class);
                startActivity(i);
            }
        });
    }
}
