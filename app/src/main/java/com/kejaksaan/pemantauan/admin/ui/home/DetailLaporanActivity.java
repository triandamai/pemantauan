package com.kejaksaan.pemantauan.admin.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.ActivityDetailLaporanBinding;
import com.squareup.picasso.Picasso;
import com.tdn.data.persistensi.MyUser;
import com.tdn.data.service.ApiService;
import com.tdn.domain.model.LaporanModel;

public class DetailLaporanActivity extends AppCompatActivity {
    private ActivityDetailLaporanBinding binding;
    private GoogleMap gmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_laporan);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Detail Laporan Pegawai");
        if (MyUser.getInstance(this).getLastLaporan() != null) {
            LaporanModel l = MyUser.getInstance(this).getLastLaporan();
            Picasso.get().load(ApiService.BASE_URL_IMAGE + l.getMedia()).into(binding.ivBukti);
            binding.tvNama.setText("Nama : " + l.getNamaLengkap());
            binding.tvNrp.setText("NRP : " + l.getNrp());
            binding.tvDeskripsi.setText("Ket : \n" + l.getDeskripsi());
            binding.mapview.onCreate(savedInstanceState);
            binding.mapview.onResume();
            try {
                MapsInitializer.initialize(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            binding.mapview.getMapAsync(googleMap -> {
                gmaps = googleMap;


                gmaps.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(l.getLat()), Double.parseDouble(l.getLng()))).title("Lokasi Pengambilan Gambar"));
                LatLng latLng = new LatLng(Double.parseDouble(l.getLat()), Double.parseDouble(l.getLng()));
                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(9).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            });
        } else {
            Snackbar.make(binding.getRoot(), "Gagal Mengambil Informasi!", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
        }
    }
}