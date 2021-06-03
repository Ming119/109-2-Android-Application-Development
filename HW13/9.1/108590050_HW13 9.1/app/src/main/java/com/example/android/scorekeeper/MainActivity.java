package com.example.android.scorekeeper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private SharedPreferences sharedPreferences;
    private static final String sharedPrefFile = "com.example.android.scorekeeper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        mScore1 = sharedPreferences.getInt(STATE_SCORE_1, 0);
        mScore2 = sharedPreferences.getInt(STATE_SCORE_2, 0);

        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        else
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode)
        {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            recreate();
        }

        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(STATE_SCORE_1, mScore1);
        editor.putInt(STATE_SCORE_2, mScore2);

        editor.apply();
    }

    public void increaseScore(@NonNull View view) {
        switch (view.getId()) {
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;

            default: break;
        }
    }

    public void decreaseScore(@NonNull View view) {
        switch (view.getId()) {
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.decreaseTeam2:

                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;

            default: break;
        }
    }

    public void onBtnResetClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();

        mScore1 = 0;
        mScore2 = 0;

        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));
    }

}