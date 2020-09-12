package com.kejaksaan.pemantauan.admin.ui.pantau;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
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
import com.tdn.domain.model.TitikModel;
import com.tdn.domain.object.LokasiObject;
import com.tdn.domain.object.TitikObject;

import java.util.List;


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

        binding.fab.setOnClickListener(v -> {
            mViewModel.getFromApi();
            new Handler().postDelayed(() -> {
                mViewModel.getFromLocal();

            }, 1000);
        });
        binding.mapview.onCreate(savedInstanceState);
        binding.mapview.onResume();
        try {
            MapsInitializer.initialize(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        observe(mViewModel);
        binding.mapview.onResume();
    }

    private void observe(PantauViewModel mViewModel) {
        mViewModel.getListLiveData().observe(getViewLifecycleOwner(), lokasiObjects -> {
            if (lokasiObjects != null) {
                if (lokasiObjects.size() > 0) {

                    binding.mapview.getMapAsync(googleMap -> {
                        gmaps = googleMap;
                        for (LokasiObject o : lokasiObjects) {
                            MarkerOptions options = new MarkerOptions();
                            options.position(new LatLng(
                                    Double.parseDouble(o.getLat()),
                                    Double.parseDouble(o.getLng()))).anchor(0.5f, 0.5f)
                                    .title("Lokasi " + o.getNamaLengkap())
                                    .snippet(o.getNip());
                            gmaps.addMarker(options);

                        }
                        LatLng latLng = new LatLng(Double.parseDouble(lokasiObjects.get(0).getLat()), Double.parseDouble(lokasiObjects.get(0).getLng()));
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(9).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    });
                }
            }
        });
        mViewModel.getListtitikData().observe(getViewLifecycleOwner(), titikModels -> {
            if (titikModels != null) {
                if (titikModels.size() > 0) {

                    binding.mapview.getMapAsync(googleMap -> {
                        gmaps = googleMap;
                        for (TitikObject o : titikModels) {
                            MarkerOptions options = new MarkerOptions();
                            options.position(new LatLng(
                                    Double.parseDouble(o.getLat()),
                                    Double.parseDouble(o.getLng()))).anchor(0.5f, 0.5f)
                                    .title("Lokasi " + o.getNama())
                                    .snippet(o.getDetail());
                            gmaps.addMarker(options);

                        }
                        LatLng latLng = new LatLng(Double.parseDouble(titikModels.get(0).getLat()), Double.parseDouble(titikModels.get(0).getLng()));
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(9).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    });
                }
            }
        });
    }
}
