package com.android.fundamentals.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.BuildConfig;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private static final String EXTRA_NUMBER = "NUMBER";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String numberString = intent.getStringExtra(EXTRA_NUMBER);
        int number = Integer.parseInt(numberString);

        if (intentAction != null) {
            String toastMessage = context.getString(R.string.unknown_action);

            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_connected);
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.power_disconnected);
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custom_broadcast_toast);
                    toastMessage += ("\nSquare of the Random number: " + number*number);
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
