package com.roberterrera.services_lab;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rob on 3/2/16.
 */
public class MusicPlayerService extends Service {

    static MediaPlayer player = new MediaPlayer();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (!player.isPlaying()) {
                    onPlay();
                    Log.d("ON_START_COMMAND", "Player is playing");
                } else {
                    onPause();
                    Log.d("ON_START_COMMAND", "Player is paused.");
                }
            }
        };
        new Thread(runnable).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(MusicPlayerService.this, "Service rendered (er... created).", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null){
            player.release();
            Toast.makeText(MusicPlayerService.this, "Music is dead", Toast.LENGTH_SHORT).show();
        }
    }


    // Methods
    public void onPlay(){
        try {
            String url = "http://download.lisztonian.com/music/download/Clair+de+Lune-113.mp3";
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.start();
                }
            });
        } catch (Throwable thr){
        }

//        Toast.makeText(MusicPlayerService.this, "Music should be playing.", Toast.LENGTH_SHORT).show();
    }

    public void onPause() {
        player.pause();
    }
}
