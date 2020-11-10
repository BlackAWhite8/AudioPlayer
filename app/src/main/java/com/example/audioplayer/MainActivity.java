package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player1;
    Button btnPlay,btnPause,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = MediaPlayer.create(this,R.raw.music);
        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                player1.stop();
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
                try {
                    player1.prepare();
                    player1.seekTo(0);
                    btnPlay.setEnabled(true);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnPlay = (Button) findViewById(R.id.play);
        btnPause = (Button) findViewById(R.id.pause);
        btnStop = (Button) findViewById(R.id.stop);
    }
    public void play(View view) {
        player1.start();
        btnPlay.setEnabled(false);
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
    }

    public void pause(View view) {
        player1.pause();
        btnPause.setEnabled(false);
        btnPlay.setEnabled(true);
    }

    public void stop(View view) {
        player1.stop();
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        try {
            player1.prepare();
            player1.seekTo(0);
            btnPlay.setEnabled(true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}