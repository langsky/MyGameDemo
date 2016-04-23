package com.tcl.hgl.mygamedemo.impl;

import android.media.SoundPool;

import com.tcl.hgl.mygamedemo.myInterface.Sound;

/**
 * Created by swd1 on 16-4-20.
 */
public class AndroidSound implements Sound {

    int soundId;
    SoundPool soundPool;

    public AndroidSound(int soundId, SoundPool soundPool) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }


    @Override
    public void play(float volume) {
        soundPool.play(soundId,volume,volume,0,0,1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }
}
