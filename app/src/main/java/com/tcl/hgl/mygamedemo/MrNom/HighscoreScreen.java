package com.tcl.hgl.mygamedemo.MrNom;

import com.tcl.hgl.mygamedemo.myInterface.Game;
import com.tcl.hgl.mygamedemo.myInterface.Graphics;
import com.tcl.hgl.mygamedemo.myInterface.Input;
import com.tcl.hgl.mygamedemo.myInterface.Screen;

import java.util.List;

/**
 * Created by swd1 on 16-4-23.
 */
public class HighscoreScreen extends Screen {

    String[] lines = new String[5];

    protected HighscoreScreen(Game game) {
        super(game);

        for(int i=0;i<5;i++)
            lines[i]=""+(i+1)+". "+Settings.highscores[i];
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents =game.getInput().getToucheEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i=0;i<len;i++){
            Input.TouchEvent touchEvent = touchEvents.get(i);
            if (touchEvent.type== Input.TouchEvent.TOUCH_UP){
                if (touchEvent.x<64&&touchEvent.y>416){
                    game.setScreen(new MainMenuScreen(game));
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
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background,0,0);
        g.drawPixmap(Assets.mainMenu,64,20,0,42,196,42);

        int y=100;
        for (int i =0;i<5;i++){
            drawText(g,lines[i],20,y);
            y+=50;
        }
        g.drawPixmap(Assets.buttons,0,416,64,64,64,64);
    }

    private void drawText(Graphics g, String line, int x, int y) {
        int len=line.length();
        for (int i=0;i<len;i++){
            char character = line.charAt(i);

            if (character==' '){
                x+=20;
                continue;
            }
            int srcX =0;
            int srcWidth = 0;
            if (character =='.'){
                srcX =200;
                srcWidth =10;
            }else {
                srcX = (character-'0')*20;
                srcWidth= 20;
            }
            g.drawPixmap(Assets.numbers,x,y,srcX,0,srcWidth,32);
            x+=srcWidth;
        }

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
