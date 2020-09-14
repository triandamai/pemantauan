package com.kejaksaan.pemantauan.Pegawai.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.ImagePickerActivity;
import com.kejaksaan.pemantauan.MyActivity;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.core.VMFactory;
import com.kejaksaan.pemantauan.core.callback.ActionListener;
import com.kejaksaan.pemantauan.databinding.ActivityTambahLaporanBinding;
import com.tdn.domain.object.LokasiObject;

import java.io.IOException;

import static com.kejaksaan.pemantauan.ImagePickerActivity.showImagePickerOptions;
import static com.kejaksaan.pemantauan.core.Utility.hideKeyboard;

public class TambahLaporan extends MyActivity {
    private ActivityTambahLaporanBinding binding;
    private TambahLaporanViewModel viewModel;
    private GoogleMap gmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tambah_laporan);
        getSupportActionBar().setTitle("Tambah Laporan");
        viewModel = new ViewModelProvider(this, new VMFactory(this, new ActionListener() {
            @Override
            public void onStart() {
                Snackbar.make(binding.btnSimpan, "Proses..", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
            }

            @Override
            public void onSuccess(@NonNull String message) {
                Snackbar.make(binding.btnSimpan, message, BaseTransientBottomBar.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onError(@NonNull String message) {
                Snackbar.make(binding.btnSimpan, message, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        })).get(TambahLaporanViewModel.class);
        binding.mapview.onCreate(savedInstanceState);
        binding.mapview.onResume();
        try {
            MapsInitializer.initialize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        binding.mapview.getMapAsync(googleMap -> {
            gmaps = googleMap;

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            gmaps.setMyLocationEnabled(true);
            // Check if we were successful in obtaining the map.
            if (gmaps != null) {
                gmaps.setOnMyLocationChangeListener(arg0 -> {
                    viewModel.lat.setValue(String.valueOf(arg0.getLatitude()));
                    viewModel.lng.setValue(String.valueOf(arg0.getLongitude()));
                    gmaps.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("Saya Disini"));
                    LatLng latLng = new LatLng(arg0.getLatitude(), arg0.getLongitude());
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(9).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                });
            }


        });
        onclick();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.mapview.onPause();
    }

    private void onclick() {
        binding.btnAmbilgambar.setOnClickListener(v -> {
            showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
                @Override
                public void onTakeCameraSelected() {
                    launchCameraIntent();
                }

                @Override
                public void onChooseGallerySelected() {
                    launchGalleryIntent();
                }
            });

        });

        binding.btnSimpan.setOnClickListener(v -> {

            hideKeyboard(this);
            viewModel.simpan(binding.etKet.getText().toString());

        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    // loading profile image from local cache

                    binding.ivPrev.setVisibility(View.VISIBLE);
                    binding.ivPrev.setImageBitmap(bitmap);
                    viewModel.foto.setValue(encodeImage(bitmap));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}