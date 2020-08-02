package com.kejaksaan.pemantauan;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Admin extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    LinearLayout datapenduduk, tambahdata, tentang, delete, logout;
    private Context context = Admin.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        loadFragment(new HomeAdminFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeAdminFragment();
                break;
            case R.id.nav_tambah_pegawai:
                fragment = new TambahPegawaiFragment();
                break;
            case R.id.nav_lokasi_admin:
                fragment = new PantauFragment();
                break;
            case R.id.nav_tentang_admin:
                fragment = new TentangFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }
        return false;
    }
}
