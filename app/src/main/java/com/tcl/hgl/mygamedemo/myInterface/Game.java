package com.tcl.hgl.mygamedemo.myInterface;

/**
 * Created by swd1 on 16-4-23.
 */
public interface Game {
     Input getInput();
     FileIO getFileIO();
    Graphics getGraphics();
    Audio getAudio();
    void setScreen(Screen screen);
    Screen getCurrentScreen();
    Screen getStartScreen();


}
