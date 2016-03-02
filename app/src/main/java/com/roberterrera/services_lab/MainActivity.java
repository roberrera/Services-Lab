package com.roberterrera.services_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mPlayButton, mPauseButton, mDestroyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = (Button) findViewById(R.id.play_button);
        mPauseButton = (Button) findViewById(R.id.play_button);
        mDestroyButton = (Button) findViewById(R.id.play_button);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                startService(playIntent);
            }
        });


        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pauseIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                startService(pauseIntent);
            }
        });

        mDestroyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destroyIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                stopService(destroyIntent);
            }
        });
    }
}
