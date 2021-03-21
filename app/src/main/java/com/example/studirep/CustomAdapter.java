package com.example.studirep;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private Context context ;
    private ArrayList recipeId, recipe_name, ingredient, cooktime,method;



    CustomAdapter(Context context , ArrayList recipeId, ArrayList recipe_name, ArrayList ingredient, ArrayList cooktime,ArrayList method){
        this.context = context;
        this.recipeId= recipeId;
        this.recipe_name= recipe_name;
        this.ingredient = ingredient;
        this.cooktime = cooktime;
        this.method = method;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recipeid.setText(String.valueOf(recipeId.get(position)));
        holder.recipeName_txt.setText(String.valueOf(recipe_name.get(position)));
        holder.mainIngredient.setText(String.valueOf(ingredient.get(position)));
        holder.cooktime_txt.setText(String.valueOf(cooktime.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new  Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf(recipeId.get(position)));
                intent.putExtra("recipename",String.valueOf(recipe_name.get(position)));
                intent.putExtra("ingredient",String.valueOf(ingredient.get(position)));
                intent.putExtra("cooktime",String.valueOf(cooktime.get(position)));
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return recipeId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView recipeid,recipeName_txt,mainIngredient,cooktime_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeid = itemView.findViewById(R.id.recipeid);
            recipeName_txt = itemView.findViewById(R.id.recipeName_txt);
            mainIngredient = itemView.findViewById(R.id.mainIngredient);
            cooktime_txt = itemView.findViewById(R.id.cooktime_txt);
            mainLayout=itemView.findViewById(R.id.mainLayout);

        }
    }
}
