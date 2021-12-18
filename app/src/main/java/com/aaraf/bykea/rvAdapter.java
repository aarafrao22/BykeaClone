package com.aaraf.bykea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder> {

    private List<Integer> integerList;
    private List<String> colorList;
    private List<String> stringList;
    private RVClickInterface rvClickInterface;
    String color;

    public rvAdapter(List<Integer> integerList,List<String> stringList,List<String> colorList,RVClickInterface rvClickInterface){
        this.integerList = integerList;
        this.stringList = stringList;
        this.colorList = colorList;
        this.rvClickInterface = rvClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = stringList.get(position);
        holder.textView.setText(item);
        Integer itemInt = integerList.get(position);
        holder.imageView.setImageResource(itemInt);

//        Picasso.get().load(integerList.get(position));

        color = colorList.get(position);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtRvItem);
            imageView = itemView.findViewById(R.id.imgRvItem);
//            itemView.setBackgroundColor(Color.parseColor(color));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvClickInterface.OnItemClick(getAdapterPosition());
                }
            });

        }
    }
}
