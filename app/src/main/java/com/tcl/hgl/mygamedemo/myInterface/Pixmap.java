package com.tcl.hgl.mygamedemo.myInterface;



/**
 * Created by swd1 on 16-4-23.
 */
public interface Pixmap {
    int getWidth();
    int getHeight();
    Graphics.PixmapFormat getFormat();
    void dispose();
}
