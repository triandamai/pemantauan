package com.kejaksaan.pemantauan.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kejaksaan.pemantauan.Pegawai.PegawaiActivity;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.admin.ui.home.DaftarPegawai;
import com.kejaksaan.pemantauan.admin.ui.home.ListPresensi;
import com.kejaksaan.pemantauan.auth.LoginUser;
import com.kejaksaan.pemantauan.databinding.ActivityAdminBinding;
import com.tdn.data.persistensi.MyUser;

public class AdminActivity extends AppCompatActivity {


    private Context context = AdminActivity.this;
    private ActivityAdminBinding binding;
    BottomNavigationView navView;
    AppBarConfiguration appBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin);
        navView = binding.navView;
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_pegawai, R.id.nav_lokasi_admin, R.id.nav_tentang_admin
        ).build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                MyUser.getInstance(AdminActivity.this).signOut();
                startActivity(new Intent(AdminActivity.this, LoginUser.class));
                finish();
                return true;
            case R.id.daftar_presensi:
                startActivity(new Intent(AdminActivity.this, ListPresensi.class));
                return true;
            case R.id.daftar_pegawai:
                startActivity(new Intent(AdminActivity.this, DaftarPegawai.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
