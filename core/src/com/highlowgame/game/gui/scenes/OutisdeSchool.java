package com.highlowgame.game.gui.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.actors.Character;
import com.highlowgame.game.actors.UiButton;
import com.highlowgame.game.gui.AbstractScreen;
import com.highlowgame.game.gui.RicoGame;
import com.highlowgame.game.gui.dialouge.InsideSchoolDialouge;
import com.highlowgame.game.gui.dialouge.OutsideSchoolDialouge;
import com.highlowgame.game.math.TextAnimation;

public class OutisdeSchool extends AbstractScreen {
    Texture background = new Texture("backgrounds/schoolOutside.jpg");
    OutsideSchoolDialouge dialouge = new OutsideSchoolDialouge();
    TextAnimation animation = new TextAnimation("");
    boolean doneOnce =false;

    Texture choice1Texture = new Texture("choices/walkHome.png");
    Texture choice2Texture = new Texture("choices/takeTheBus.png");
    Texture unknownCharacter = new Texture("characters/msyteryGirl.png");

    public OutisdeSchool(RicoGame game) {
        super(game);
        girl=new Character(unknownCharacter,0,0);
        characterNeffects.addActor(girl);
        girl.setVisible(false);
        game.font.setColor(Color.BLUE);
        gameBackground.setEffectSprite(background);
        initChoiceButtons();
        choice1.setVisible(false);
        choice2.setVisible(false);
        game.songs.playOutside();
    }
    private void initChoiceButtons()
    {
        choice1 = initButton(choice1,choice1Texture,0, 600);
        choice2 = initButton(choice2,choice2Texture,0,450);
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
        renderHelpMenu();
        stage.getBatch().end();
        checkForButtonClicks();
        checkForChoice();

    }

    private void checkForChoice()
    {
        if(choice1.isClicked())
        {
            choiceActivated=false;
            choiceSelected=0;
            choice1.setClicked(false);
            choice1.setVisible(false);
            choice2.setVisible(false);
            upDimmer.setVisible(false);
            downDimmer.setVisible(false);
            dialougeIndex++;
        }
        else if(choice2.isClicked())
        {
            choiceActivated=false;
            choiceSelected=1;
            choice2.setClicked(false);
            game.songs.stopSound();
            game.songs.stopMusic();
            game.setScreen(new GoodEnd(game));
            choice1.setVisible(false);
            choice2.setVisible(false);
            upDimmer.setVisible(false);
            downDimmer.setVisible(false);
            dialougeIndex++;
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
        if(dialouge.getCharacter(dialougeIndex).equals("???")&&!doneOnce)
        {
            doneOnce=true;
            girl.setVisible(true);
            game.songs.playOutsideSchoolandOutside();
        }
    }

    @Override
    public void skipText() {
        if(choiceSelected>-1) {
            dialougeIndex = dialouge.size() - 1;
        }
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

            game.setScreen(new Outside(game));
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