package com.tcl.hgl.mygamedemo.MrNom;



import com.tcl.hgl.mygamedemo.impl.AndroidGame;
import com.tcl.hgl.mygamedemo.myInterface.Screen;

public class MrNomGame extends AndroidGame {

    @Override
    public void setScreen(Screen screen) {

    }

    @Override
    public Screen getCurrentScreen() {
        return null;
    }

    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
