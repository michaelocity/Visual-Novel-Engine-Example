package com.highlowgame.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Character extends Actor {
    private Sprite charSprite;

    public Character(Texture charTexture, float xPos, float yPos)
    {
        setX(xPos);
        setY(yPos);
        charSprite = new Sprite(charTexture);
        setWidth(charSprite.getWidth());
        setHeight(charSprite.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public void setCharSprite(Texture charSprite) {
        this.charSprite = new Sprite(charSprite);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(charSprite, getX(), getY());
    }
}
