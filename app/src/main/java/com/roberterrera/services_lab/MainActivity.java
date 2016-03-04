package com.roberterrera.services_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mDestroyButton;
    ImageButton mPlayButton;
    boolean mPlay = true;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = (ImageButton) findViewById(R.id.play_button);
        mDestroyButton = (Button) findViewById(R.id.destroy_button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( progressBar.getVisibility() == View.VISIBLE ) {
                    progressBar.setVisibility(View.GONE);
                    mPlayButton.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    mPlayButton.setImageResource(android.R.drawable.ic_media_pause);
                }
                Toast.makeText(MainActivity.this, "Play button pressed", Toast.LENGTH_SHORT).show();
                Intent playIntent = new Intent(MainActivity.this, MusicPlayerService.class);
                if (mPlay = true) {
                    playIntent.setAction("PLAY");
                    startService(playIntent);
                    mPlay = false;
                } else {
                    playIntent.setAction("PAUSE");
                    startService(playIntent);
                    mPlay = true;
                }
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
