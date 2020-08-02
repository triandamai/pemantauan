package com.kejaksaan.pemantauan;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kejaksaan.pemantauan.databinding.ActivityAdminBinding;

public class Admin extends AppCompatActivity {


    private Context context = Admin.this;
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
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_inventory, menu);
        return true;
    }

}
