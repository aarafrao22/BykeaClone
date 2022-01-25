package com.aaraf.bykea;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dropOffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_off);

        BottomNavigationView navigationView = findViewById(R.id.topNav);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.area:
                    selectedFragment = new AreaFragment();
                    break;
                case R.id.search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.saved:
                    selectedFragment = new SavedFragment();
                    break;
                case R.id.recent:
                    selectedFragment = new RecentFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
            return true;
        }
    };
}