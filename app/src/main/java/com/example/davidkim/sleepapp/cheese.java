package com.example.davidkim.sleepapp;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class cheese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);

        // stop music player
        MusicPlayer.stopMusic();

        Button btnvideo = (Button) this.findViewById(R.id.pauseButton);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        final VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView1);
//        String uriPath2 = "android.resource://com.example.davidkim.sleepApp/"+R.raw.logo;
        String uriPath2 = "android.resource://".concat(getPackageName()).concat("/raw/").concat(""+R.raw.cheesecake);
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();

        btnvideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mVideoView2.isPlaying()) {
                    mVideoView2.start();
                }
                else {
                    mVideoView2.pause();
                }
//                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
//                String uriPath = "android.resource://".concat(getPackageName()).concat("/raw/").concat(""+R.raw.loaf);
//                Uri uri2 = Uri.parse(uriPath);
//                mVideoView2.setVideoURI(uri2);
//                mVideoView2.requestFocus();
//                mVideoView2.start();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //back button
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, VideosActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
