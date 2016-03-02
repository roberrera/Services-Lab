package com.roberterrera.services_lab;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Rob on 3/2/16.
 */
public class MusicPlayerService extends Service {

    final MediaPlayer player = new MediaPlayer();
    String url = "http://download.lisztonian.com/music/download/Clair+de+Lune-113.mp3";


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
                playMusic(url);
            }
        };
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(MusicPlayerService.this, "Service created.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                pauseMusic(url);
            }
        };
    }


    // Methods
    public void playMusic(String url){
        try {
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
    }

    public void pauseMusic(String url){
        try {
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.stop();
                }
            });
        } catch (Throwable thr){
        }
    }

}
