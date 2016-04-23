package com.tcl.hgl.mygamedemo.MrNom;


import com.tcl.hgl.mygamedemo.myInterface.Game;
import com.tcl.hgl.mygamedemo.myInterface.Graphics;

import com.tcl.hgl.mygamedemo.myInterface.Screen;


/**
 * Created by swd1 on 16-4-23.
 */
public class LoadingScreen extends Screen {

    protected LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics graphics= game.getGraphics();
         Assets.background =graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.logo=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.mainMenu=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.help1=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.help2=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.help3=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.numbers=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.ready=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.pause=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.gameOver=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.headUp=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.headDown=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.headLeft=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.headRight=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.tail=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.stain1=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.stain2=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.stain3=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);
        Assets.buttons=graphics.newPixmap("", Graphics.PixmapFormat.ARGB4444);

        Assets.click=game.getAudio().newSound("");
        Assets.eat=game.getAudio().newSound("");
        Assets.bitten=game.getAudio().newSound("");

        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

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
