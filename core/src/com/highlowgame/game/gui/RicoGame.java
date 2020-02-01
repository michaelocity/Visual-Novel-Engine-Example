package com.highlowgame.game.gui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ObjectMap;
import com.highlowgame.game.gui.scenes.Outside;
import com.highlowgame.game.gui.scenes.TrueEnd;
import com.highlowgame.game.ui.SoundManager;

public class RicoGame  extends Game {
    public static int screenResX = 900;
    public static int screenResY = 900;

    public SpriteBatch batch;
    public BitmapFont font;
    public int girlNum=-1; //kyoko, sayaka, madoka, mami, homura
    String[] girlNames = {"Kyoko", "Sayaka", "Madoka", "Mami", "Homura"};
    static ObjectMap<String, BitmapFont> fonts;
    public int correct=0;
    public int incorrect=0;
    public boolean betLvl;
    public SoundManager songs;

    public void create() {
        songs = new SoundManager();
        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();

        this.setScreen(new MainMenuScreen(this));
    }



    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
