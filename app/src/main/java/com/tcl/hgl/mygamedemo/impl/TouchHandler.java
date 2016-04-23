package com.tcl.hgl.mygamedemo.impl;

import android.view.View;

import com.tcl.hgl.mygamedemo.myInterface.Input;

import java.util.List;

/**
 * Created by swd1 on 16-4-23.
 */
public interface TouchHandler extends View.OnTouchListener {
    boolean isTouchDown(int pointer);

    int getTouchX(int pointer);

    int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}
