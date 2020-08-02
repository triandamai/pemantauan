package com.kejaksaan.pemantauan;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.tdn.data.LocationInterval;

public class LocationService extends Service {
    private LocationInterval locationInterval = new LocationInterval();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        locationInterval.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!locationInterval.isAlive()) {
            locationInterval.start();
        }
        return Service.START_REDELIVER_INTENT;
    }
}
