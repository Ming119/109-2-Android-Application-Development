package edu.ntut.a108590050_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate()", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCount = (TextView) findViewById(R.id.text_count);

        if (savedInstanceState != null) {
            String saveCount = savedInstanceState.getString("count");
            count = Integer.parseInt(saveCount);
            if (textCount != null) {
                textCount.setText(saveCount);
            }
        }
    }

    @Override
    protected void onStart() {
        Log.d("onStart()", "onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("onRestart()", "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("onResume()", "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("onPause()", "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("onStop()", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("onDestroy()", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("onSaveInstanceState()", "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(textCount.getText()));
    }

    public void clickHandler_count(View buttonCount) {
        count ++;

        if (textCount != null) {
            textCount.setText(Integer.toString(count));
        }

    }
}