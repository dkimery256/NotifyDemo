package com.kimery.notifydemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotifyDemo extends AppCompatActivity {

    //Build the object that will be the notification
    NotificationCompat.Builder notify;
    private static final int uniqueID = 7676; //the notification has to assigned a unique ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_demo);

        //build new notification
        notify = new NotificationCompat.Builder(this);
        //remove notification once it has been visited
        notify.setAutoCancel(true);


    }
    //customize the notify
    public void onNotifyClick(View view) {
        notify.setSmallIcon(R.mipmap.ic_launcher);
        notify.setTicker("This is the ticker");
        notify.setWhen(System.currentTimeMillis());
        notify.setContentTitle("Here is the title");
        notify.setContentText("Body of the notify");

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notify.setSound(alarmSound);

        //send the notify to the home screen
        Intent i = new Intent(this, NotifyDemo.class);
        //give the device access to perform this intent by calling pending intent
        PendingIntent pi = PendingIntent.getActivity(this, 0 , i , PendingIntent.FLAG_UPDATE_CURRENT);
        notify.setContentIntent(pi);

        //send out the notification
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notify.build());


    }
}
