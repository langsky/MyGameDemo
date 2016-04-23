package com.tcl.hgl.mygamedemo.myInterface;

/**
 * Created by swd1 on 16-4-23.
 */
public abstract class Screen  {
    protected final Game game;

    protected Screen(Game game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);
    public abstract void present(float deltaTime);
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
