package com.tcl.hgl.mygamedemo.impl;

import android.app.Activity;

import android.content.res.Configuration;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.os.PowerManager;
import android.view.Window;
import android.view.WindowManager;

import com.tcl.hgl.mygamedemo.myInterface.Audio;
import com.tcl.hgl.mygamedemo.myInterface.FileIO;
import com.tcl.hgl.mygamedemo.myInterface.Game;
import com.tcl.hgl.mygamedemo.myInterface.Graphics;
import com.tcl.hgl.mygamedemo.myInterface.Input;
import com.tcl.hgl.mygamedemo.myInterface.Screen;

/**
 * Created by swd1 on 16-4-23.
 */
public abstract class AndroidGame extends Activity implements Game {
    AndroidFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isLandscape = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape?480:320;
        int frameBufferHeight = isLandscape?320:480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Bitmap.Config.RGB_565);
        float scaleX = (float)frameBufferWidth/getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float)frameBufferHeight/getWindowManager().getDefaultDisplay().getHeight();

        renderView = new AndroidFastRenderView(this,frameBuffer);
        graphics = new AndroidGraphics(getAssets(),frameBuffer);
        fileIO = new AndroidFileIO(this);
        input = new AndroidInput(this,renderView,scaleX,scaleY);
        audio = new AndroidAudio(this);
        screen = getStartScreen();
        setContentView(renderView);

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock=powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,"GLGame");

    }

    @Override
    protected void onResume() {
        super.onResume();
        wakeLock.acquire();
        screen.resume();
        renderView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release();
        renderView.pause();
        screen.pause();

        if(isFinishing())
            screen.dispose();
    }

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }
}
