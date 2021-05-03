package com.example.android.hellotoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageBattery;
    private int imageLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageBattery = findViewById(R.id.imageBattery);

        if (savedInstanceState == null)
            imageLevel = 0;
        else
            imageLevel = savedInstanceState.getInt("imageLevel");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("imageLevel", this.imageLevel);
    }

    public void onButtonClick(View btn) {
        if (btn.getId() == R.id.btn_plus) {
            if (imageLevel < 6) {
                imageLevel++;
                imageBattery.setImageLevel(imageLevel);
            }
        }

        if (btn.getId() == R.id.bnt_minus) {
            if (imageLevel > 0) {
                imageLevel--;
                imageBattery.setImageLevel(imageLevel);
            }
        }

    }

}
