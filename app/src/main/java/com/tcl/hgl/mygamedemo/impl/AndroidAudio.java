package com.tcl.hgl.mygamedemo.impl;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.tcl.hgl.mygamedemo.myInterface.Audio;
import com.tcl.hgl.mygamedemo.myInterface.Music;
import com.tcl.hgl.mygamedemo.myInterface.Sound;

import java.io.IOException;

/**
 * Created by swd1 on 16-4-20.
 */
public class AndroidAudio implements Audio {

    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC,0);
    }

    @Override
    public Music newMusic(String filename) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(filename);
            return new AndroidMusic(assetFileDescriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sound newSound(String filename) {
        try {
            AssetFileDescriptor assetFileDescriptor = assets.openFd(filename);
            int id = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(id, soundPool);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
