package com.highlowgame.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.highlowgame.game.gui.RicoGame;

public class ScreenEffect extends Actor {
    private Sprite effectSprite;

    //typically the effect should be transparent to do a dimm/ distort effect
    public ScreenEffect(Texture effectTexture)
    {
        setX(0);
        setY(0);
        effectSprite = new Sprite(effectTexture);
        setWidth(RicoGame.screenResX);
        setHeight(RicoGame.screenResY);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public void setEffectSprite(Texture effectTexture) {
        this.effectSprite = new Sprite(effectTexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(effectSprite, getX(), getY(),getWidth(),getHeight());
    }
}