package com.tcl.hgl.mygamedemo.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by swd1 on 16-4-23.
 */
public class AndroidFastRenderView extends SurfaceView implements Runnable {
    AndroidGame game;
    Bitmap framebuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running =false;

    public AndroidFastRenderView(AndroidGame androidGame, Bitmap frameBuffer) {
        super(androidGame);
        this.game = androidGame;
        this.framebuffer = frameBuffer;
        this.holder = getHolder();
    }

    public void resume(){
        running =true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    public void pause(){
        running = false;
        while (true){
            try {
                renderThread.join();
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void run() {
        Rect dstRect = new Rect();
        long startTime= System.nanoTime();
        while (running){
            if (!holder.getSurface().isValid())
                continue;
            
            float deltaTime = (System.nanoTime()-startTime)/1000000000.0f;
            startTime = System.nanoTime();

            game.getCurrentScreen().update(deltaTime);
            game.getCurrentScreen().present(deltaTime);

            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer,null,dstRect,null);
            holder.unlockCanvasAndPost(canvas);
        }
    }
}
