package com.ikurek.pwr;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import layout.RadioFragment;

import static java.security.AccessController.getContext;

public class RadioService extends Service implements MediaPlayer.OnPreparedListener {

    MediaPlayer radioPlayer;
    String url = "http://radioluz.pwr.wroc.pl:8000/luzhifi.mp3";
    String action;
    NotificationManager notificationManager;
    int NOTIFICATION_ID = 80085;


    public RadioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.e("Service", "Bind");

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Service", "onStart");
        action = intent.getAction();
        Log.e("ServiceAction", action);

        //Zrób powiadomienie
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_play_arrow_black_24dp)
                        .setContentTitle("Radio LUZ")
                        .setContentText("Radio LUZ jest odtwarzane w tle");



        Intent targetIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());






        switch (action) {

            case "play":
            radioPlayer = new MediaPlayer();
            radioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            try {
                radioPlayer.setDataSource(url);
            } catch (IOException e) {
                Log.e("setDataSource", e.toString());
            }

            radioPlayer.prepareAsync();
            radioPlayer.setOnPreparedListener(this);

        }



        return START_STICKY;

    }

    @Override
    public void onPrepared(MediaPlayer radioPlayer) {

        //odpal player
        Log.e("Service", "onPrepared");
        radioPlayer.start();


    }


    @Override
    public void onDestroy() {

        Log.e("Service", "onDestroy");

        if(notificationManager != null) {
            notificationManager.cancelAll();
        }

        //Zwolnij mediaplayer
        if(radioPlayer != null && radioPlayer.isPlaying()) {
            radioPlayer.stop();
            radioPlayer.reset();
            radioPlayer.release();
        }


        super.onDestroy();
    }
}
