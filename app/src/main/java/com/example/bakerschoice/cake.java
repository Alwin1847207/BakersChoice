package com.example.bakerschoice;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cake extends Fragment{

    private View view;
    private RecyclerView recyclerView;
    private ArrayList<cake_model> modelist;
    private cake_adapter dashboard_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cake, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Items").child("Cakes");

        modelist = new ArrayList<cake_model>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                modelist.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String k=dataSnapshot1.getKey();
                    String price= dataSnapshot1.child("price").getValue(String.class);
                    String name= dataSnapshot1.child("name").getValue(String.class);
                    Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();

                    cake_model modl=new cake_model(name,price);
                    modelist.add(modl);
                }

                dashboard_adapter = new cake_adapter(getActivity(), modelist);
                recyclerView.setAdapter(dashboard_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Error....!!", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
