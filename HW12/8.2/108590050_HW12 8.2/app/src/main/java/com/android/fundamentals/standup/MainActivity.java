package com.android.fundamentals.standup;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (alarmManager != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR, 11);
                        calendar.set(Calendar.MINUTE, 11);

                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), notifyPendingIntent);

                        Toast.makeText(MainActivity.this, R.string.alarm_on_toast, Toast.LENGTH_LONG).show();
                    }

                } else {
                    if (alarmManager != null) {
                        alarmManager.cancel(notifyPendingIntent);
                        mNotificationManager.cancelAll();

                        Toast.makeText(MainActivity.this, R.string.alarm_off_toast, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();
    }

    public void createNotificationChannel() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Make a Wish notification", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notifies at 11:11 everyday.");

            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
