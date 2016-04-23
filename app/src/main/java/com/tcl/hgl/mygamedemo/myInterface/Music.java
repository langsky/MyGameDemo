package com.tcl.hgl.mygamedemo.myInterface;

/**
 * Created by swd1 on 16-4-20.
 */
public interface Music {
    void play();
    void stop();
    void pause();
    void setLooping (boolean looping);
    void setVolume (float volume);
    boolean isPlaying();
    boolean isLooping();
    boolean isStoped();
    void dispose();
}
