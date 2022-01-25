package com.aaraf.bykea;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.aaraf.bykea.databinding.ActivityRideBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RideActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityRideBinding binding;
    private LinearLayout dropOff;

    private LocationManager locationManager;

    //Github Token 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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dropOff = findViewById(R.id.btnSelectDropOff);

        dropOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dropOff = new Intent(getApplicationContext(),dropOffActivity.class);
                startActivity(dropOff);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        Location location2 = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        Location location3 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

        double longitude = location3.getLongitude();
        double latitude = location3.getLatitude();

        LatLng myLocation = new LatLng(latitude, longitude);
        LatLng sydney1 = new LatLng(24.920569, 67.046729);
        LatLng sydney2 = new LatLng(24.920464, 67.047681);
        LatLng sydney3 = new LatLng(24.920943, 67.047053);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Bykea 1").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location"));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Bykea 2").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Bykea 3").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Bykea 4").icon(bitmapDescriptorFromVector(this,R.drawable.ic_baseline_sports_motorsports_24)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        mMap.setMinZoomPreference(18f);
        CircleOptions circleOptions = new CircleOptions().center(myLocation).radius(40).strokeWidth(4).strokeColor(Color.rgb(255,0,0)).fillColor(Color.argb(80,255,0,0));
        mMap.addCircle(circleOptions);


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