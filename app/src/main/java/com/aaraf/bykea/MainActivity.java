package com.aaraf.bykea;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Intent intent,intIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtBykea);
        textView.animate().scaleXBy(8f).scaleYBy(8f).setDuration(900);

        checkConnection();

    }

    private void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (null != networkInfo) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }, 1490);

        }else {
            intIntent = new Intent(getApplicationContext(), NoInternetActivity.class);
            startActivity(intIntent);
            finish();
        }

    }
}