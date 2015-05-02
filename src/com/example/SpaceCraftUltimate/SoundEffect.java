package com.example.SpaceCraftUltimate;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundEffect {

    private static MediaPlayer mp;
    private static Context context;

    private static SoundPool soundPool;
    private static HashMap soundPoolMap;


    public static final int S1 = R.raw.laser;
    public static final int S2 = R.raw.explosion;
    public static final int S3 = R.raw.aircraft;


    /**
     * Populate the SoundPool
     */
    public static void initSounds(Context con) {

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(3);
        context = con;

        soundPoolMap.put(S1, soundPool.load(context, R.raw.laser, 1));
        soundPoolMap.put(S2, soundPool.load(context, R.raw.explosion, 1));
        soundPoolMap.put(S3, soundPool.load(context, R.raw.aircraft, 1));
    }


    /**
     * Play a given sound in the soundPool
     */
    public static void playSound(Context context, int soundID) {
        if (soundPool == null || soundPoolMap == null) {
            initSounds(context);
        }
        float volume = 0.8f;// whatever in the range = 0.0 to 1.0


        // play sound with same right and left volume, with a priority of 1,
        // zero repeats (i.e play once), and a playback rate of 1f
        soundPool.play((Integer) soundPoolMap.get(soundID), volume, volume, 1, 0, 1f);
    }

    static void fireSound() {
        if (soundPool == null || soundPoolMap == null) {
            initSounds(context);
        }
        float volume = 0.8f;// whatever in the range = 0.0 to 1.0
        soundPool.play((Integer) soundPoolMap.get(S1), volume, volume, 1, 0, 1f);
    }


    static void CollissionSound() {
        if (soundPool == null || soundPoolMap == null) {
            initSounds(context);
        }
        float volume = 0.8f;// whatever in the range = 0.0 to 1.0
        soundPool.play((Integer) soundPoolMap.get(S2), volume, volume, 1, 0, 1f);


    }

    static void backgroundMusic() {

        if (soundPool == null || soundPoolMap == null) {
            initSounds(context);
        }
        float volume = 0.7f;

        // whatever in the range = 0.0 to 1.0

        while (soundPool.play((Integer) soundPoolMap.get(S3), volume, volume, 1, -1, 1f) == 0)
            ;              // soundPool.setLoop(S3, 1);


    }


    static void release() {


        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }


}
