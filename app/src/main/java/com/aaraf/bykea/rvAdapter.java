package com.aaraf.bykea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder>{

    private ArrayList<RvModel> listItems;
    private Context context;
    String color;
    ClickListener clickListener;

    public rvAdapter(List<RvModel> listItems, Context context,ClickListener clickListener) {
        this.listItems = (ArrayList<RvModel>) listItems;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(listItems.get(position).getName(), listItems.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtRvItem);
            imageView = itemView.findViewById(R.id.imgRvItem);
//            itemView.setBackgroundColor(Color.parseColor(color));
        }

        private void setData(String name, String image) {
            this.textView.setText(name);
            Glide.with(itemView.getContext()).load(image).into(imageView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClicked(getAdapterPosition());
        }
    }
}
