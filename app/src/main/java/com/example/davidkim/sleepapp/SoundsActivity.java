package com.example.davidkim.sleepapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SoundsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);
        ImageButton ib = (ImageButton) this.findViewById(R.id.buttonrain);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(SoundsActivity.this, R.raw.rain);
                mp.start();
                mp.setLooping(true);
                startActivity(new Intent(SoundsActivity.this,MainActivity.class));
            }
        });
    }
}
