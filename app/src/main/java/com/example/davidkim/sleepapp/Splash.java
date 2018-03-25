package com.example.davidkim.sleepapp;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // stop music player
        MusicPlayer.stopMusic();

        Button btnvideo = (Button) this.findViewById(R.id.passButton);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        final VideoView mVideoView2 = (VideoView)findViewById(R.id.logoScreen);
        String uriPath2 = "android.resource://".concat(getPackageName()).concat("/raw/").concat(""+R.raw.logo);
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();

        btnvideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
