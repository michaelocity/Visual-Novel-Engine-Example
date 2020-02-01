package com.highlowgame.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> cardDeck;
    int suit=4;
    int numOfCards=13;

    Cards[] cards = {Cards.Ace,Cards.two,Cards.three,Cards.four,Cards.five,Cards.six,Cards.seven,Cards.eight,Cards.nine,
    Cards.ten,Cards.jack,Cards.queen,Cards.king};
    Suit[] suits = {Suit.diamond,Suit.spade,Suit.clover,Suit.heart};

    ArrayList<Card> randomDeck;
    ArrayList<Card> usedPile = new ArrayList<Card>();


    public Deck(Stage stage, Vector2 position)
    {
        cardDeck = new ArrayList<Card>(suit*numOfCards);
        randomDeck = new ArrayList<Card>(suit*numOfCards);

        for(int i =0; i<numOfCards;i++)
        {
            cardDeck.add(i*4,new Card(cards[i],suits[0],position.x,position.y));
            cardDeck.add(i*4+1,new Card(cards[i],suits[1],position.x,position.y));
            cardDeck.add(i*4+2,new Card(cards[i],suits[2],position.x,position.y));
            cardDeck.add(i*4+3,new Card(cards[i],suits[3],position.x,position.y));
            System.out.println("deckSize:"+cardDeck.size());
        }

        randomizeCards(stage);
    }
    public void randomizeCards(Stage stage)
    {

        while (randomDeck.size()<cardDeck.size()) {
            randomDeck.add(cardDeck.get(new Random().nextInt(cardDeck.size() - 1)));
            System.out.println(randomDeck.get(randomDeck.size()-1));
            stage.addActor(randomDeck.get(randomDeck.size()-1));
            randomDeck.get(randomDeck.size()-1).setVisible(false);
        }
        for (int i =0; i<randomDeck.size();i++)
        {

            randomDeck.get(i).addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Gdx.app.log("Clicked card at", x + "   " + y);
                }
            });
        }
    }
    public void shuffle()
    {
        for(int i=0; i<randomDeck.size();i++)
        {
            Card temp =randomDeck.remove((int)(Math.random()*randomDeck.size()));
            randomDeck.add(temp);
        }
    }

    public Card getNextCard()
    {
        usedPile.add(randomDeck.remove(0));
        return  usedPile.get(usedPile.size()-1);
    }

    public void renderRandomCards(Batch batch,float x, float y)
    {

        for (Card card: randomDeck)
        {
            card.draw(batch,0.5f);
        }
    }
}
