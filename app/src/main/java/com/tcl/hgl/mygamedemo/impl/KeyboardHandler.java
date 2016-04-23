package com.tcl.hgl.mygamedemo.impl;


import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.tcl.hgl.mygamedemo.myInterface.Input.KeyEvent;

/**
 * Created by swd1 on 16-4-23.
 */
public class KeyboardHandler implements View.OnKeyListener {

    boolean[] pressKeys = new boolean[128];
    Pool<KeyEvent> keyEventPool;
    List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent>();
    List<KeyEvent> keyEvents = new ArrayList<>();


    public KeyboardHandler(View view) {
        Pool.PoolObjectFactory<KeyEvent> factory = new Pool.PoolObjectFactory<KeyEvent>() {
            @Override
            public KeyEvent createObject() {
                return new KeyEvent();
            }
        };
        keyEventPool = new Pool<>(factory,100);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    @Override
    public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
        if (event.getAction()==android.view.KeyEvent.ACTION_MULTIPLE)
            return false;
        synchronized (this){
            KeyEvent keyEvent = keyEventPool.newObject();
            keyEvent.keyCode = keyCode;
            keyEvent.keyChar = (char)event.getUnicodeChar();

            if (event.getAction() == android.view.KeyEvent.ACTION_UP){
                keyEvent.type =keyEvent.KEY_UP;
                if (keyCode>0&&keyCode<127)
                    pressKeys[keyCode] = false;
            }
            if (event.getAction() == android.view.KeyEvent.ACTION_DOWN){
                keyEvent.type =keyEvent.KEY_DOWN;
                if (keyCode>0&&keyCode<127)
                    pressKeys[keyCode] = false;
            }
            keyEventsBuffer.add(keyEvent);
        }
        return false;
    }

    public boolean isKeyPressed(int keyCode) {
        if (keyCode<0||keyCode>127)
            return false;
        return pressKeys[keyCode];
    }

    public List<KeyEvent> getKeyEvents(){
        synchronized (this){
            int len = keyEvents.size();
            for (int i=0;i<len;i++){
                keyEventPool.free(keyEvents.get(i));
            }
            keyEvents.clear();
            keyEvents.addAll(keyEventsBuffer);
            keyEventsBuffer.clear();
            return keyEvents;
        }
    }

}