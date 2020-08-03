package com.tdn.data;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.tdn.data.service.ApiService;
import com.tdn.domain.serialize.req.RequestPostUpdateLocation;
import com.tdn.domain.serialize.res.ResponseAction;

import java.text.DateFormat;
import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tdn.data.service.ApiHandler.cek;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public class LocationInterval extends Thread {

    private double lat = 0;
    private double lng = 0;
    private LocationListener locationListener;
    private ApiService apiService = ApiService.Factory.create();


    @SuppressLint("MissingPermission")
    @Override
    public void run() {
        super.run();


        while (true) {
            try {

                locationListener = location -> {
                    lat = location.getLatitude();
                    lng = location.getLongitude();
                    //  sendLocation(lat, lng);
                    Log.e("kirim lokasi", "Kirim Lokasi");
                };


                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}


