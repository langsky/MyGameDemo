package com.tcl.hgl.mygamedemo.MrNom;

import com.tcl.hgl.mygamedemo.myInterface.Game;
import com.tcl.hgl.mygamedemo.myInterface.Graphics;
import com.tcl.hgl.mygamedemo.myInterface.Input;
import com.tcl.hgl.mygamedemo.myInterface.Screen;

import java.util.List;


/**
 * Created by swd1 on 16-4-23.
 */
public class HelpScreen extends Screen{
    protected HelpScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents =game.getInput().getToucheEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++){
            Input.TouchEvent touchEvent = touchEvents.get(i);
            if (touchEvent.type== Input.TouchEvent.TOUCH_UP){
                if (touchEvent.x>256&&touchEvent.y>46){
                    game.setScreen(new HelpScreen2(game));
                    if (Settings.soundEnabled){
                        Assets.click.play(1);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawPixmap(Assets.background,0,0);
        graphics.drawPixmap(Assets.help1,64,100);
        graphics.drawPixmap(Assets.buttons,256,416,0,64,64,64);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
