package com.example.searching;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.foodViewHolder>{

    private ArrayList<foodItem> foodItemList;
    public static class foodViewHolder extends RecyclerView.ViewHolder {
        public TextView foodNameLine;
        public TextView foodTypeLine;
        //public TextView foodWeightLine;
        public foodViewHolder(View itemView) {
            super(itemView);
            foodNameLine = itemView.findViewById(R.id.textview_line1);
            foodTypeLine = itemView.findViewById(R.id.textview_line_2);
            //foodWeightLine = itemView.findViewById(R.id.textview_line_3);
        }
    }
    public foodAdapter(ArrayList<foodItem> foodList) {
        foodItemList = foodList;
    }
    @Override
    public foodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        foodViewHolder food = new foodViewHolder(v);

        return food;
    }
    @Override
    public void onBindViewHolder(foodViewHolder holder, int position) {
        foodItem thisItem = foodItemList.get(position);
        holder.foodNameLine.setText(thisItem.getFoodName());
        holder.foodTypeLine.setText(thisItem.getFoodType());
        //holder.foodWeightLine.setText(thisItem.getFoodWeight());
    }
    @Override
    public int getItemCount() {
        return foodItemList.size();
    }
}
