package com.example.sherawat42.notificationsdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button mNotifyButton;
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;


    Intent notificationIntent;
    PendingIntent notificationPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%203/81_p_notifications.html?q=

//        https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%203/81_p_notifications.html?q=
        mNotifyButton = (Button) findViewById(R.id.notify);

        mNotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });

        notificationIntent = new Intent(this, MainActivity.class);
        notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        mNotifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


    }


    private static int i=0;

    public void sendNotification() {
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("You've been notified!")
                .setContentText("This is your detailed notificatio" +
                        "n text.")
                .setSmallIcon(R.mipmap.my_icon)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(notificationPendingIntent);


        Notification myNotification = notifyBuilder.build();
        i=i+1;
        mNotifyManager.notify(NOTIFICATION_ID+i, myNotification);
    }
}
