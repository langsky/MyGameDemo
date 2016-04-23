package com.tcl.hgl.mygamedemo.myInterface;


import java.util.List;

/**
 * Created by swd1 on 16-4-20.
 */
public interface Input {

    class KeyEvent {

        public int KEY_DOWN = 0;
        public int KEY_UP = 1;

        public int type;
        public int keyCode;
        public char keyChar; //must be public or other class cannot access to it
    }

    class TouchEvent {
        public static int TOUCH_DOWN = 0;
        public static int TOUCH_UP = 1;
        public static int TOUCH_DRAGGED = 2; //must be static for SingleHandler.java

        public int type;
        public int x, y;
        public int pointer;


    }

    boolean isKeyPressed(int keyCode);

    boolean isTouchDown(int pointer);

    int getTouchX(int pointer);

    int getTouchY(int pointer);

    float getAccelX();

    float getAccelY();

    float getAccelZ();

    List<TouchEvent> getToucheEvents();

    List<KeyEvent> getKeyEvents();


}
