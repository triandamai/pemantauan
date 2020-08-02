package com.tdn.data;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
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

public class LocationInterval extends Thread {
    private DecimalFormat dateFormat;
    private FusedLocationProviderClient locationProviderClient;
    private double lat = 0;
    private double lng = 0;
    private ApiService apiService = ApiService.Factory.create();

    @SuppressLint("MissingPermission")
    @Override
    public void run() {
        super.run();
        dateFormat = new DecimalFormat();


        while (true) {
            try {


                locationProviderClient.getLastLocation().addOnSuccessListener(location -> {
                    if (location != null) {
                        lat = location.getLatitude();
                        lng = location.getLongitude();
                        sendLocation(lat, lng);
                    }

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void sendLocation(double lat, double lng) {
        try {
            RequestPostUpdateLocation requestPostUpdateLocation = new RequestPostUpdateLocation();
            requestPostUpdateLocation.setId("1");
            requestPostUpdateLocation.setLat(String.valueOf(lat));
            requestPostUpdateLocation.setLng(String.valueOf(lng));
            apiService.updateLocation(requestPostUpdateLocation).enqueue(new Callback<ResponseAction>() {
                @Override
                public void onResponse(Call<ResponseAction> call, Response<ResponseAction> response) {
                    if (cek(response.code())) {
                        if (cek(response.body().getResponseCode())) {

                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseAction> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }
    }
}
