package com.highlowgame.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UiButton extends Actor {
    private Sprite buttonSprite;
    private boolean clicked;

    public UiButton(Texture buttonTexture, float xPos, float yPos)
    {
        clicked=false;
        System.out.println(clicked);
        setX(xPos);
        setY(yPos);
        buttonSprite = new Sprite(buttonTexture);
        setWidth(buttonSprite.getWidth());
        setHeight(buttonSprite.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());

        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Clicked button at", x + "   " + y);
                clicked=true;
            }
        });
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(buttonSprite, getX(), getY());
    }
}
