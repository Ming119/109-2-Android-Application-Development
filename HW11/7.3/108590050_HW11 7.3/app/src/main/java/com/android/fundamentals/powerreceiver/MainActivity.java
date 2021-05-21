package com.android.fundamentals.powerreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.constraint.BuildConfig;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    private static final String EXTRA_NUMBER = "NUMBER";

    private CustomReceiver mReceiver = new CustomReceiver();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(mReceiver, filter);

        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);

        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);

        int number = randomNumber();
        customBroadcastIntent.putExtra(EXTRA_NUMBER, String.valueOf(number));
        textView.setText(String.valueOf(number));

        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}
