package com.example.a19mobileproject5;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;

import java.io.IOException;
import java.util.List;

public class TabFragment3 extends Fragment implements OnMapReadyCallback, View.OnClickListener {

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    EditText editPlace;
    Button btnSearch;


    public TabFragment3() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_fragment_3, container, false);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        editPlace = layout.findViewById(R.id.editPlace);
        btnSearch = layout.findViewById(R.id.btnSearch);


        if (!Places.isInitialized()) {
            Places.initialize(requireContext(), "AIzaSyCjZxOveu2G0A4YCUcWpQs4nMUeD9weJVk");
        }


        fectcLastLocation();

        final FloatingActionButton fac = layout.findViewById(R.id.current);
        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fectcLastLocation();
            }
        });


        return layout;
    }


    private void fectcLastLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        final Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;

                    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(TabFragment3.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .title("현재 위치");
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        googleMap.addMarker(markerOptions);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                search();
                String place = editPlace.getText().toString();
                Geocoder coder = new Geocoder(getActivity());
                List<Address> list = null;
                try {
                    list = coder.getFromLocationName(place, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Address addr = list.get(0);
                if (addr == null) {
                    Toast.makeText(getActivity(), "검색된 위치가 없습니다", Toast.LENGTH_LONG).show();
                } else {
                    double lat = addr.getLatitude();
                    double log = addr.getLongitude();
                    LatLng geoPoint = new LatLng(lat, log);
                    if (geoPoint == null) {
                        fectcLastLocation();
                        Toast.makeText(getActivity(), "주소를 자세히 입력해 주세요", Toast.LENGTH_LONG).show();
                    } else {
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(geoPoint, 15));
                    }
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fectcLastLocation();
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {

    }
}
