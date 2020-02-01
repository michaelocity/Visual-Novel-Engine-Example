package com.highlowgame.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Card extends Actor {
    Sprite cardSprite;
    public Cards cards;
    public Suit suit;

    public Card(Cards cardType, Suit suit, float x, float y) {
        setX(x);
        setY(y);
        this.cards = cardType;
        this.suit = suit;
        cardSprite = new Sprite(new Texture(Gdx.files.internal("cards/" + cardType.getValue() + suit.getFile())));
        setWidth(cardSprite.getWidth()*2);
        setHeight(cardSprite.getHeight()*2);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public int isGreater(Card card)
    {
        return cards.compareTo(card.cards);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(cardSprite, getX(), getY(),getWidth(),getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX((float) Math.random() * 50);
    }

}
