package com.roberterrera.services_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mPlayButton, mPauseButton, mDestroyButton;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = (Button) findViewById(R.id.play_button);
        mPauseButton = (Button) findViewById(R.id.pause_button);
        mDestroyButton = (Button) findViewById(R.id.destroy_button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Play button pressed", Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                startService(playIntent);
            }
        });


        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Play button pressed", Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                startService(playIntent);
                progressBar.setVisibility(View.GONE);
            }
        });

        mDestroyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destroyIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                stopService(destroyIntent);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
