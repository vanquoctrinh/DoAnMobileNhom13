package com.example.bottomnavi.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bottomnavi.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {

    ArrayList<FoodDomain> popularFood;

    public PopularAdaptor(ArrayList<FoodDomain> categoryFood) {
        this.popularFood = categoryFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.titlepopu.setText(popularFood.get(position).getTitle());
    holder.fee.setText(String.valueOf(popularFood.get(position).getMoney()));

    int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titlepopu,fee;
        ImageView pic;
        TextView Addbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlepopu = itemView.findViewById(R.id.title_popu);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.imageView);
            Addbtn = itemView.findViewById(R.id.Addbtn);
        }
    }
}
