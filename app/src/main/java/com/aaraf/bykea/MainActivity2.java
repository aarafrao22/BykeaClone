package com.aaraf.bykea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements ClickListener{

    private RecyclerView recyclerView;
    private ImageView imageBanner;
    private ImageView btnBarCall;
    private Context context;

    private DatabaseReference databaseReference;
    private ArrayList<RvModel> listItems;
    private rvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.MainRecyclerView);
        imageBanner = findViewById(R.id.imageBanner);
        btnBarCall = findViewById(R.id.btnBarCall);

        btnBarCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(getApplicationContext(),CallActivity.class);
                startActivity(callIntent);
            }
        });

        imageBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Banner Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference();
        listItems = new ArrayList<RvModel>();

        clearAll();
        getDataFromFireBase();
        rvAdapter = new rvAdapter(listItems,context,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rvAdapter);
        RecyclerView.LayoutManager linearLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    private void getDataFromFireBase() {
        Query query = databaseReference.child("listItems");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    listItems.add(snapshot1.getValue(RvModel.class));
                }
                rvAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void clearAll() {
        if (listItems!=null){
            listItems.clear();

            if (rvAdapter!=null){
                rvAdapter.notifyDataSetChanged();
            }
        }
        listItems = new ArrayList<>();

    }

    @Override
    public void onItemClicked(int position) {
        String temp = listItems.get(position).getName();
        switch (temp){
            case "Ride":
                Intent rideIntent = new Intent(getApplicationContext(),RideActivity.class);
                startActivity(rideIntent);

            case "Cash":

        }
    }
}