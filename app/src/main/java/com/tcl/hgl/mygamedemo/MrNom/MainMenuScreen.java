package com.tcl.hgl.mygamedemo.MrNom;

import com.tcl.hgl.mygamedemo.myInterface.Game;
import com.tcl.hgl.mygamedemo.myInterface.Graphics;
import com.tcl.hgl.mygamedemo.myInterface.Input;
import com.tcl.hgl.mygamedemo.myInterface.Screen;

import java.util.List;
import java.util.Set;

/**
 * Created by swd1 on 16-4-23.
 */
public class MainMenuScreen extends Screen{

    protected MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics graphics = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getToucheEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent touchEvent = touchEvents.get(i);
            if (touchEvent.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(touchEvent, 0, graphics.getHeight() - 64, 64, 64)) {
                    Settings.soundEnabled = !Settings.soundEnabled;
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                }
                if (inBounds(touchEvent, 64, 220, 192, 42)) {
                    game.setScreen(new GameScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                if (inBounds(touchEvent, 64, 220 + 42, 192, 42)) {
                    game.setScreen(new HighscoreScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                if (inBounds(touchEvent, 64, 220 + 84, 192, 42)) {
                    game.setScreen(new HelpScreen(game));
                    if (Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    private boolean inBounds(Input.TouchEvent touchEvent, int x, int y, int width, int height) {
        if (touchEvent.x>x&&touchEvent.x<x+width-1&&touchEvent.y>y&&touchEvent.y<y+height-1)
            return true;
        else
            return false;
    }


    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background,0,0);
        g.drawPixmap(Assets.logo,32,20);
        g.drawPixmap(Assets.mainMenu,64,220);
        if (Settings.soundEnabled)
            g.drawPixmap(Assets.buttons,0,416,0,0,64,64);
        else
            g.drawPixmap(Assets.buttons,0,416,64,0,64,64);
    }

    @Override
    public void pause() {
        Settings.save(game.getFileIO());

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
