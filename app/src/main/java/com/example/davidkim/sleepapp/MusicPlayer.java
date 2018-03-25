package com.example.davidkim.sleepapp;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Kenny Lee on 3/24/2018.
 */

public class MusicPlayer {
    private static MediaPlayer sounds;
    private static Context context;

    //private static boolean isMuted = false;

    public static void setContext(Context cont){
        context = cont;
    }

    public static boolean isPlaying() {
        if(sounds != null) return true;
        else return false;
    }

    public static void playMusic(int resource){
        if(sounds != null) sounds.reset();

        try{
            sounds = MediaPlayer.create(context, resource);

            sounds.setLooping(true);
            sounds.setVolume(100, 100);

            sounds.start();

        } catch (NullPointerException e){
            //Creating MediaPlayer failed. This happens randomly without any clear reasons.
            e.printStackTrace();
        }
    }

//    public static void setMuted(boolean muted){
//        if(sounds != null){
//            if(muted){
//                if(sounds.isPlaying()){
//                    sounds.stop();
//                    isMuted = true;
//                }
//            } else {
//                if(!sounds.isPlaying()){
//                    sounds.start();
//                    isMuted = false;
//                }
//            }
//        }
//    }

    public static void stopMusic(){
        if(sounds != null){
            sounds.reset();
        }
    }
}
