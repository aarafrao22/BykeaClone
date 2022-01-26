package com.aaraf.bykea;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AreaFragment extends Fragment {

    private RecyclerView recyclerViewArea;
    private AreaAdapter adapter;

    private List<AreaModel> areaModelList;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.areafragment,container,false);
        recyclerViewArea = view.findViewById(R.id.rvArea);
        areaModelList = new ArrayList<AreaModel>();
        areaModelList.add(new AreaModel("Gulshan"));
        areaModelList.add(new AreaModel("Karimabad"));
        areaModelList.add(new AreaModel("Haideri"));

        recyclerViewArea.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AreaAdapter(areaModelList,context);
        recyclerViewArea.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;


    }
}
