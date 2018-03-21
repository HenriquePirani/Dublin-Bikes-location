package com.example.henri.apitest;
// Henrique Magalhaes Pirani 14759
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DownloadTask doo = new DownloadTask();

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
        
        // Lists created to get the values from the lists inside Download class
        ArrayList<String> mydata2 = new ArrayList<String>();
        ArrayList<Double> mylat2 = new ArrayList<Double>();
        ArrayList<Double> mylng2 = new ArrayList<Double>();
        ArrayList<String> myAddres2 = new ArrayList<String>();
        mydata2 = doo.mydata;
        mylat2 = doo.mylat;
        mylng2 = doo.mylng;
        myAddres2 = doo.myAddres;
        LatLng Dublin = new LatLng(53.3498,-6.2603 );

       // Log.i("AAAA:", String.valueOf(mydata2.size()));
// Put the markers on all Dublin bike locations
        for(int i = 0;i<mydata2.size(); i++) {
            LatLng bikeLoc = new LatLng(mylat2.get(i),mylng2.get(i) );
            mMap.addMarker(new MarkerOptions().position(bikeLoc).title(myAddres2.get(i)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Dublin, 12)); // Zoom camera on top of Dublin

    }
}
