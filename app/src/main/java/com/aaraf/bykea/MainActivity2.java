package com.aaraf.bykea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity implements RVClickInterface {

    private RecyclerView recyclerView;
    private List<Integer> integerList;
    private List<String> colorList;
    private List<String> stringList;
    private ImageView imageBanner;

    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

//        FirebaseRecyclerOptions<RvModel> options = new FirebaseRecyclerOptions.
//                Builder<RvModel>().setQuery(FirebaseDatabase.getInstance().getReference().child("")).build();

        recyclerView = findViewById(R.id.MainRecyclerView);
        imageBanner = findViewById(R.id.imageBanner);

        imageBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Banner Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        integerList = new ArrayList<>();

        stringList = new ArrayList<>();
        stringList.add("Cash");
        stringList.add("Ride");
        stringList.add("Delivery");
        stringList.add("Khareed Lao");
        stringList.add("Shops");
        stringList.add("Mazay");

        colorList = new ArrayList<>();
        colorList.add("#121212");
        colorList.add("#121212");
        colorList.add("#000000");
        colorList.add("#ffffff");
        colorList.add("#121212");
        colorList.add("#121212");

        rvAdapter adapter = new rvAdapter(integerList, stringList, colorList, this);
        RecyclerView.LayoutManager linearLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnItemClick(int position) {
//        Toast.makeText(getApplicationContext(), stringList.get(position)+" Clicked", Toast.LENGTH_SHORT).show();
        switch (stringList.get(position)) {
            case "Cash":
                break;
            case "Ride":
                Intent rideIntent = new Intent(MainActivity2.this, RideActivity.class);
                startActivity(rideIntent);
                break;
            case "Delivery":
            case "Khareed Lao":
            case "Shops":
            case "Mazay":
        }
    }
}