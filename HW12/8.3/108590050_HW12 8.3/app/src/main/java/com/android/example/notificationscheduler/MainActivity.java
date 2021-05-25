package com.android.example.notificationscheduler;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;

    public class DownloadService extends JobService {
        @Override
        public boolean onStartJob(JobParameters jobParameters) {
            sendNotification();
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,"Download Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Download Notification");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }

    }

    public void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle(getResources().getString(R.string.notification_title))
                .setContentText(getResources().getString(R.string.notification_text))
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_job_running)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(0, builder.build());
    }

    public void btnDownload(View btn) {
        sendNotification();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), DownloadService.class.getName());

        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPeriodic(TimeUnit.DAYS.toMillis(1));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setPeriodic(TimeUnit.DAYS.toMillis(1), TimeUnit.MINUTES.toMillis(5));
        }

        if (jobScheduler != null)
            jobScheduler.schedule(builder.build());

    }
}
