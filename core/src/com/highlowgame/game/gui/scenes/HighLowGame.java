package com.highlowgame.game.gui.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.actors.Character;
import com.highlowgame.game.actors.UiButton;
import com.highlowgame.game.cards.Card;
import com.highlowgame.game.cards.Deck;
import com.highlowgame.game.gui.AbstractScreen;
import com.highlowgame.game.gui.RicoGame;
import com.highlowgame.game.gui.dialouge.QuoteDialouge;
import com.highlowgame.game.math.GirlSpriteHandler;
import com.highlowgame.game.math.TextAnimation;

public class HighLowGame extends AbstractScreen {
    Texture background = new Texture("backgrounds/casinoTable.png");
    QuoteDialouge dialouge = new QuoteDialouge();
    TextAnimation animation = new TextAnimation("");

    Texture scoreBoardTexture = new Texture("buttons/scorechart.png");
    Texture choice1Texture = new Texture("buttons/lowerButton.jpg");
    Texture choice2Texture = new Texture("buttons/higherButton.jpg");
    Texture girlSprite;
    GirlSpriteHandler girlSprites;
    UiButton scoreCount;
    Deck deckOfCards;
    Card cardShown;
    boolean lowerClicked=false;
    boolean higherClicked=false;

    public HighLowGame(RicoGame game) {
        super(game);
        girlSprites=new GirlSpriteHandler();
        System.out.println(girlSprites.magicalImageUrls.get(game.girlNum));
        girlSprite = new Texture(new GirlSpriteHandler().magicalImageUrls.get(game.girlNum));
        girl=new Character(girlSprite,0,0);
        characterNeffects.addActor(girl);
        game.font.setColor(Color.BLUE);
        gameBackground.setEffectSprite(background);
        initChoiceButtons();
        deckOfCards=new Deck(stage,new Vector2(400,400));
        girl.setVisible(true);
        cardShown = deckOfCards.getNextCard();
       characterNeffects.addActor(cardShown);
       cardShown.setVisible(true);
       scoreCount=new UiButton(scoreBoardTexture,200,650);
       characterNeffects.addActor(scoreCount);
    }
    private void updateCard()
    {
        characterNeffects.removeActor(cardShown);
        Card temp = deckOfCards.getNextCard();
        checkForHighLow(temp,cardShown);
        cardShown = temp;
        characterNeffects.addActor(cardShown);
        cardShown.setVisible(true);
    }
    private void checkForHighLow(Card next, Card origional)
    {
        int temp = origional.cards.compareTo(next.cards);
        checkIfCorrect(temp);
    }
    private void checkIfCorrect(int temp)
    {
        System.out.println("higher or lower: "+temp);
        if(temp==0)
        {
            return;
        }
        else if(temp<0&&lowerClicked)
        {
            game.correct++;
            return;
        }
        else if(temp>0&&!lowerClicked)
        {
            game.correct++;
            return;
        }
        game.incorrect++;
    }



    private void initChoiceButtons()
    {

        choice1 =new UiButton(choice1Texture,580,300);
        buttons.addActor(choice1);
        choice2 = new UiButton(choice2Texture,580,500);
        buttons.addActor(choice2);
        choice1.setVisible(true);
        choice2.setVisible(true);
    }

    @Override
    public void render(float delta) {
        checkForInBounds();
        checkForEvent();
        updateAnimatedText();
        animation.animateTyping(delta);
        stage.draw();
        stage.getBatch().begin();
        drawCorrectDialouge(dialouge.getCharacter(dialougeIndex), animation.getEdited());
        game.font.getData().setScale(6f);
        drawText(""+game.incorrect/3,275,770);
        drawText(""+game.correct,525,770);
        game.font.getData().setScale(2f);
        renderHelpMenu();
        stage.getBatch().end();
        checkForButtonClicks();
        checkForChoice();
        checkForChange();
        checkEndState();
    }
    private void checkEndState()
    {
        if(game.incorrect>=9)
        {
            game.songs.stopMusic();
            game.setScreen(new JustBadEnd(game));
        }
        else if(game.correct>10&&game.betLvl)
        {
            game.songs.stopMusic();
            game.setScreen(new TrueEnd(game));
        }
        else if(game.correct>5&&!game.betLvl)
        {
            game.songs.stopMusic();
            game.setScreen(new NeutralEnd(game));
        }
    }
    private void checkForChange()
    {
        if(dialougeIndex>6)
        {
            System.out.println(dialougeIndex);
            girlSprite = new Texture(new GirlSpriteHandler().basicImageUrls.get(game.girlNum));
            characterNeffects.removeActor(girl);
            girl=new Character(girlSprite,0,0);
            characterNeffects.addActor(girl);
        }
        else
        {
            girlSprite = new Texture(new GirlSpriteHandler().magicalImageUrls.get(game.girlNum));
            characterNeffects.removeActor(girl);
            girl=new Character(girlSprite,0,0);
            characterNeffects.addActor(girl);
        }
    }

    private void checkForChoice()
    {
        if(choice1.isClicked())
        {
            lowerClicked=true;
            higherClicked=false;
            updateCard();
            choice1.setClicked(false);
            System.out.println("chose lower");
        }
        else if(choice2.isClicked())
        {
            lowerClicked=false;
            higherClicked=true;
            updateCard();
            choice2.setClicked(false);
        }
    }


    public void checkForEvent()
    {
        if(dialouge.getCharacter(dialougeIndex).equals("Choice"))
        {
            choice1.setVisible(true);
            choice2.setVisible(true);
            upDimmer.setVisible(true);
            downDimmer.setVisible(true);
            choiceActivated=true;
        }
        if(dialouge.getCharacter(dialougeIndex).equals("???"))
        {
            girl.setVisible(true);
        }
    }

    @Override
    public void skipText() {
        dialougeIndex = dialouge.size() - 1;
    }

    @Override
    public void renderHelpMenu() {
        if (helpMenuOpen) {
            game.font.setColor(Color.RED);
            drawText("Go through the story of Grader" +
                    "\n Later on you will play higher or lower", 100, 500);
            game.font.setColor(Color.BLUE);
        }
    }

    private void checkForInBounds() {
        if (dialougeIndex > dialouge.size() - 1) {
            dialougeIndex = dialouge.size() - 1;
            game.songs.stopMusic();
            game.setScreen(new HighLowGame(game));
        }
    }

    @Override
    public void updateAnimatedText() {

        if (!dialouge.getDialouge(dialougeIndex).equals(animation.getOriginalText())) {
            if(dialouge.getCharacter(dialougeIndex).equals("Choice"))
            {
                animation = new TextAnimation(dialouge.getDialouge(dialougeIndex),3f);
                return;
            }
            animation = new TextAnimation(dialouge.getDialouge(dialougeIndex));
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
