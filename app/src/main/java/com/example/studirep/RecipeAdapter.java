package com.example.studirep;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<RecipeModal> recipeModalArrayList;
    private Context context;

    // constructor
    public RecipeAdapter(ArrayList<RecipeModal> courseModalArrayList, Context context) {
        this.recipeModalArrayList = courseModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipeitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        RecipeModal modal = recipeModalArrayList.get(position);
        holder.ViewRecipeName.setText(modal.getRecipeName());
        holder.ViewRecipeIngredient.setText(modal.getRecipeIngredient());
        holder.ViewCookTime.setText(modal.getCookTime());
        holder.ViewMethod.setText(modal.getMethod());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getRecipeName());
                i.putExtra("ingredient", modal.getRecipeIngredient());
                i.putExtra("cookTime", modal.getCookTime());
                i.putExtra("method", modal.getMethod());

                // starting our activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeModalArrayList.size();
    }

    public void filterList(ArrayList<RecipeModal> filteredList){
        recipeModalArrayList = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ViewRecipeName, ViewRecipeIngredient, ViewCookTime, ViewMethod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialize textView
            ViewRecipeName = itemView.findViewById(R.id.vwRecipeName);
            ViewRecipeIngredient = itemView.findViewById(R.id.vwRecipeIngredient);
            ViewCookTime = itemView.findViewById(R.id.vwCookTime);
            ViewMethod = itemView.findViewById(R.id.vwMethod);
        }
    }
}
