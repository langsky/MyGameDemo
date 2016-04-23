package com.tcl.hgl.mygamedemo.impl;

import android.graphics.Bitmap;

import com.tcl.hgl.mygamedemo.myInterface.Graphics;
import com.tcl.hgl.mygamedemo.myInterface.Pixmap;


/**
 * Created by swd1 on 16-4-23.
 */
public class AndroidPixmap implements Pixmap {

    Bitmap bitmap;
    Graphics.PixmapFormat format;

    public AndroidPixmap(Bitmap bitmap, Graphics.PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
