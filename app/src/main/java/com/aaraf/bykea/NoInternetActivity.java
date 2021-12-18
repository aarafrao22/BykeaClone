package com.aaraf.bykea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class NoInternetActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        layout = findViewById(R.id.btnCall);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(NoInternetActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},1);

                }else {
                    String number = "03313344034";
                    Intent intentCall = new Intent(Intent.ACTION_CALL_BUTTON,Uri.parse("tel:"+number));
                    startActivity(intentCall);
                }
            }
        });
    }
}