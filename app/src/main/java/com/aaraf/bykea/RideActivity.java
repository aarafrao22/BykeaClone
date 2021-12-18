package com.aaraf.bykea;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.aaraf.bykea.databinding.ActivityRideBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RideActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityRideBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng sydney1 = new LatLng(-34, 101);
        LatLng sydney2 = new LatLng(-31, 151);
        LatLng sydney3 = new LatLng(-30, 150);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Marker in Sydney").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Marker in Sydney").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Marker in Sydney").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney1,15));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney2,15));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney3,15));


    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vector){
        Drawable drawable = ContextCompat.getDrawable(context,vector);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}