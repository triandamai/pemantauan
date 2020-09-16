package com.kejaksaan.pemantauan.Pegawai;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kejaksaan.pemantauan.LocationService;
import com.kejaksaan.pemantauan.Pegawai.ui.home.TambahLaporan;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.auth.LoginUser;
import com.tdn.data.persistensi.MyUser;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.PegawaiModel;
import com.tdn.domain.model.UserModel;
import com.tdn.domain.serialize.req.RequestPostLogin;
import com.tdn.domain.serialize.res.ResponseAuthLogin;
import com.tdn.domain.serialize.res.ResponseGetPegawai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

public class PegawaiActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pegawai);
        getSupportActionBar();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Dexter.withActivity(PegawaiActivity.this).withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {
                    start();

                }
                if (report.isAnyPermissionPermanentlyDenied()) {
                    //
                    // showSettingsDialog();
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
        apiService = ApiService.Factory.create();
        start();
    }

    private void start() {
        Log.e("mulai", "mulai service");
        Intent service = new Intent(this, LocationService.class);
        this.startService(service);
    }

    protected void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PegawaiActivity.this);
        builder.setTitle("Izin Dibutuhkan");
        builder.setMessage("Aplikasi ingin meminta beberapa izin akses");
        builder.setPositiveButton("Pengaturan", (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    protected void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", PegawaiActivity.this.getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
//                MyUser.getInstance(PegawaiActivity.this).signOut();
//                startActivity(new Intent(PegawaiActivity.this, LoginUser.class));
//                finish();
                return true;
            case R.id.action_sinkron:
                UserModel u = MyUser.getInstance(this).getUser();

                apiService.getPegawai(u.getId())
                        .enqueue(new Callback<ResponseGetPegawai>() {
                            @Override
                            public void onResponse(Call<ResponseGetPegawai> call, Response<ResponseGetPegawai> response) {
                                Log.e("tes", response.body().toString());

                                if (response.isSuccessful()) {
                                    if (cek(response.code())) {

                                        if (cek(response.body().getResponseCode())) {
                                            if (response.body().getData() != null) {

                                                PegawaiModel p = response.body().getData().get(0);
                                                UserModel us = new UserModel();
                                                us.setPassword(p.getPassword());
                                                us.setNrp(p.getNrp());
                                                us.setNip(p.getNip());
                                                us.setLevel(p.getLevel());
                                                us.setTmt(p.getTmt());
                                                us.setNoHp(p.getNoHp());
                                                us.setNamaLengkap(p.getNamaLengkap());
                                                us.setJabatan(p.getJabatan());
                                                us.setGolonganPangkat(p.getGolonganPangkat());
                                                us.setAlamatTinggal(p.getAlamatTinggal());
                                                us.setId(p.getId());
                                                MyUser.getInstance(PegawaiActivity.this).setUser(us);
                                                Toast.makeText(PegawaiActivity.this, "Berhasil Sinkronisasi ", Toast.LENGTH_LONG).show();

                                            } else {
                                                Toast.makeText(PegawaiActivity.this, "Gagal2 Sinkronisasi ", Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            Toast.makeText(PegawaiActivity.this, "Gagal3 Sinkronisasi ", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Toast.makeText(PegawaiActivity.this, "Gagal4 Sinkronisasi ", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(PegawaiActivity.this, "Gagal5 Sinkronisasi ", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseGetPegawai> call, Throwable t) {
                                Log.e("tes", t.getMessage());
                                Toast.makeText(PegawaiActivity.this, "Gagal6 Sinkronisasi ", Toast.LENGTH_LONG).show();
                            }
                        });


                return true;
            case R.id.action_tambahlaporan:
                startActivity(new Intent(PegawaiActivity.this, TambahLaporan.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
