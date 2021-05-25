package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecipeViewHolder> {
    public final static String EXTRA_NAME = ".EXTRA.NAME";

    private final LinkedList<String> RecipeTitles;
    private final LinkedList<String> RecipeDescriptions;
    private final LayoutInflater     LayoutInflater;

    public RecyclerViewAdapter(Context context, LinkedList<String> recipeTitles, LinkedList<String> recipeDescriptions) {
        LayoutInflater          = android.view.LayoutInflater.from(context);
        this.RecipeTitles       = recipeTitles;
        this.RecipeDescriptions = recipeDescriptions;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.inflate(R.layout.recipe_list, parent, false);
        return new RecipeViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        String CurrentTitle       = RecipeTitles.get(position);
        String CurrentDescription = RecipeDescriptions.get(position);
        holder.recipeTitleTextView.setText(CurrentTitle);
        holder.recipeDescriptionTextView.setText(CurrentDescription);
    }

    @Override
    public int getItemCount() { return RecipeTitles.size(); }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeTitleTextView;
        public final TextView recipeDescriptionTextView;
        public final RecyclerViewAdapter Adapter;

        public RecipeViewHolder(View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            this.Adapter = adapter;
            itemView.setOnClickListener(this);

            recipeTitleTextView       = itemView.findViewById(R.id.recipe_title);
            recipeDescriptionTextView = itemView.findViewById(R.id.recipe_description);
        }

        @Override
        public void onClick(View view) {
            int Position = getLayoutPosition();
            String element = RecipeTitles.get(Position);

            Bundle extras = new Bundle();
            extras.putString(EXTRA_NAME, element);

            Intent intent = new Intent(view.getContext(), RecipeActivity.class);
            intent.putExtras(extras);

            view.getContext().startActivity(intent);
        }
    }
}
