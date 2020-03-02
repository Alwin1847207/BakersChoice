package com.example.bakerschoice;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cake_adapter extends RecyclerView.Adapter<cake_adapter.MyViewHolder> {

    private ArrayList<cake_model> modellist;
    private Context ctx;
    SparseBooleanArray selectedItem;
    public static int currentSelectedIndex;

    public cake_adapter(Context ctx, ArrayList<cake_model> modellist) {
        this.ctx = ctx;
        this.modellist = modellist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_name;
        TextView item_prize;

        public MyViewHolder(View view) {
            super(view);

          item_name = (TextView) view.findViewById(R.id.item_name_list);
          item_prize = (TextView) view.findViewById(R.id.item_prize_list);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @NonNull
    @java.lang.Override
    public MyViewHolder onCreateViewHolder(@NonNull android.view.ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new MyViewHolder(view);
    }

    @java.lang.Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        cake_model model = modellist.get(position);
        holder.item_name.setText(model.getItem_name());
        holder.item_prize.setText(model.getItem_prize());
      //  Toast.makeText(ctx, model.getItem_name(), Toast.LENGTH_SHORT).show();
    }

    @java.lang.Override
    public int getItemCount() {
        return modellist.size();
    }
}
