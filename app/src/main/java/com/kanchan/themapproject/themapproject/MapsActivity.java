package com.kanchan.themapproject.themapproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final static LatLng TEXAS = new LatLng(31.9686,99.9018);
    private final static LatLng MIAMI = new LatLng(25.7617,80.1918);
    private final static LatLng ATLANTA = new LatLng(33.7490,84.3880);

    private Marker mtexas;
    private  Marker mmiami;
    private Marker matlanta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<Marker> markerList = new ArrayList<>();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney and move the camera
        //LatLng mumbai = new LatLng(19.0760,72.8777 );
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(mumbai).title("Marker in Mumbai"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mumbai));

        //mMap.addMarker(new MarkerOptions().position(mumbai).title("Marker in Mumbai").
          //              icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mumbai,10));

        mtexas=mMap.addMarker(new MarkerOptions().position(TEXAS).title("Marker in Texas"));
        mtexas.setTag(0);
        markerList.add(mtexas);

        mmiami = mMap.addMarker(new MarkerOptions().position(MIAMI).title("Marker in Miami"));
        mmiami.setTag(0);
        markerList.add(mmiami);

        matlanta = mMap.addMarker(new MarkerOptions().position(ATLANTA).title("Marker in Atlanta"));
        matlanta.setTag(0);
        markerList.add(matlanta);

        for(Marker m: markerList){

            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,12));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,2));

            //Log.d(" Marker  : ", m.getTitle());
        }

    }
}
