package com.example.android.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item = null;
        TextView title;
        ImageView image = null;

        if (extras != null) {
            item = extras.getString(RecyclerViewAdapter.EXTRA_NAME);
            title = findViewById(R.id.Title);
            image = findViewById(R.id.image);
            title.setText(item);
        }

        if (item != null) {
            switch (item) {
                case "Fishballs":
                    image.setImageResource(R.drawable.img_fishballs);
                    break;

                case "Stinky tofu":
                    image.setImageResource(R.drawable.img_stinky_tofu);
                    break;

                case "Cha siu baau":
                    image.setImageResource(R.drawable.img_cha_siu_baau);
                    break;

                case "Hong Kong-style French toast":
                    image.setImageResource(R.drawable.img_hk_style_french_toast);
                    break;

                case "Chicken feet":
                    image.setImageResource(R.drawable.img_chicken_feet);
                    break;

                case "Cantonese preserved sausage":
                    image.setImageResource(R.drawable.img_cantonese_preserved_sausage);
                    break;

                case "Egg tart":
                    image.setImageResource(R.drawable.img_egg_tart);
                    break;

                case "Yung Kee's roast goose":
                    image.setImageResource(R.drawable.img_roast_goose);
                    break;

                case "Roast pigeon":
                    image.setImageResource(R.drawable.img_roast_pigeon);
                    break;

                case "Snake soup":
                    image.setImageResource(R.drawable.img_snake_soup);
                    break;

                case "Typhoon-shelter crab":
                    image.setImageResource(R.drawable.img_typhoon_shelter_crab);
                    break;

                case "Milk tea":
                    image.setImageResource(R.drawable.img_mike_tea);
                    break;

                case "Sweet and sour pork":
                    image.setImageResource(R.drawable.img_sweet_and_sour_pork);
                    break;

                case "Lotus seed paste":
                    image.setImageResource(R.drawable.img_lotus_seed_paste);
                    break;
            }
        }
    }
}
