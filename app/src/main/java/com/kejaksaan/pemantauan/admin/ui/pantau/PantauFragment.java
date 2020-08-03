package com.kejaksaan.pemantauan.admin.ui.pantau;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kejaksaan.pemantauan.R;
import com.kejaksaan.pemantauan.databinding.FragmentPantauBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class PantauFragment extends Fragment {
    private FragmentPantauBinding binding;
    private GoogleMap gmaps;
    private PantauViewModel mViewModel;

    public PantauFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_pantau, container, false);
        mViewModel = new ViewModelProvider(this).get(PantauViewModel.class);
        binding.mapview.onCreate(savedInstanceState);
        binding.mapview.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        binding.mapview.getMapAsync(googleMap -> {
            gmaps = googleMap;
            //   LatLng latLng = new LatLng(Double.parseDouble(laporanHarianObject.getLatitudeLaporanharian()), Double.parseDouble(laporanHarianObject.getLongitudeLaporanharian()));
            // gmaps.addMarker(new MarkerOptions().position(latLng).title("Lokasi Laporan").snippet(laporanHarianObject.getAlamatLaporanharian()));
            //  CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(12).build();
            //  googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        observe(mViewModel);
        binding.mapview.onResume();
    }

    private void observe(PantauViewModel mViewModel) {

    }
}
