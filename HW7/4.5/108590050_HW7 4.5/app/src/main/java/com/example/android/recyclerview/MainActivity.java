package com.example.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {
    private LinkedList<String> RecipeTitles       = new LinkedList<>();
    private LinkedList<String> RecipeDescriptions = new LinkedList<>();

    private void fileReader(InputStream input, LinkedList<String> output) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        try {
            String line;

            while ((line = reader.readLine()) != null)
                output.addLast(line);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileReader(getResources().openRawResource(R.raw.recipe_titles), RecipeTitles);
        fileReader(getResources().openRawResource(R.raw.recipe_descriptions), RecipeDescriptions);

        RecyclerViewAdapter Adapter = new RecyclerViewAdapter(this, RecipeTitles, RecipeDescriptions);
        RecyclerView recycler_view  = findViewById(R.id.RecyclerView);

        recycler_view.setAdapter(Adapter);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }
}
