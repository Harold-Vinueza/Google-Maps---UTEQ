package com.uteq.mapatursticodequevedocongooglemaps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
//        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapa.getUiSettings().setZoomControlsEnabled(true);

//        CameraUpdate camUpd1 =
//        CameraUpdateFactory.
//                newLatLngZoom(new LatLng(-1.02279, -79.46184), 13);
//        mapa.moveCamera(camUpd1);


//        LatLng madrid = new LatLng(40.68929, -74.04449);
//
//        CameraPosition camPos = new CameraPosition.Builder()
//                .target(madrid)
//                .zoom(19)
//                .bearing(45)      //noreste arriba
//                .tilt(70)         //punto de vista de la cámara 70 grados
//                .build();
//
//        CameraUpdate camUpd3 =
//                CameraUpdateFactory.newCameraPosition(camPos);
//
//        mapa.animateCamera(camUpd3);

        CameraUpdate camUpd1 = CameraUpdateFactory.
                newLatLngZoom(new LatLng(-1.0227948405526195, -79.46001175601066), 15);
        mapa.moveCamera(camUpd1);
        PolylineOptions lineas = new PolylineOptions()
            .add(new LatLng(-1.0122871529673507, -79.46695618101617))
            .add(new LatLng(-1.0118044306686012, -79.47193436088536))
            .add(new LatLng(-1.0132257794536044, -79.47203092040867))
            .add(new LatLng(-1.0136173207075063, -79.4669937319419))
            .add(new LatLng(-1.0122871529673507, -79.46695618101617));

            lineas.width(8);
            lineas.color(Color.RED);

            mapa.addPolyline(lineas);


    }
}