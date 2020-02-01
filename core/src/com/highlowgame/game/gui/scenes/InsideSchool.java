package com.highlowgame.game.gui.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.gui.AbstractScreen;
import com.highlowgame.game.gui.RicoGame;
import com.highlowgame.game.gui.dialouge.InsideSchoolDialouge;
import com.highlowgame.game.math.TextAnimation;

import java.util.regex.Pattern;

public class InsideSchool extends AbstractScreen {
    Texture background = new Texture("backgrounds/schoolInside.jpg");
    InsideSchoolDialouge dialouge = new InsideSchoolDialouge();
    TextAnimation animation = new TextAnimation("");

    public InsideSchool(RicoGame game) {
        super(game);
        game.font.setColor(Color.BLUE);
        gameBackground.setEffectSprite(background);
        game.songs.playInSchool();

    }


    @Override
    public void render(float delta) {
        checkForInBounds();
        updateAnimatedText();
        animation.animateTyping(delta);
        stage.draw();
        stage.getBatch().begin();
        drawCorrectDialouge(dialouge.getCharacter(dialougeIndex),animation.getEdited());
        renderHelpMenu();
        stage.getBatch().end();
        checkForButtonClicks();

    }

    @Override
    public void skipText() {
        dialougeIndex=dialouge.size()-1;
    }

    @Override
    public void renderHelpMenu() {
        if(helpMenuOpen) {
            game.font.setColor(Color.RED);
            drawText("Go through the story of Grader" +
                    "\n Later on you will play higher or lower", 100, 500);
            game.font.setColor(Color.BLUE);
        }
    }

    private void checkForInBounds()
    {
        if(dialougeIndex>dialouge.size()-1)
        {
            dialougeIndex=dialouge.size()-1;
            game.songs.stopMusic();
            game.setScreen(new OutisdeSchool(game));
        }
    }

    @Override
    public void updateAnimatedText() {

        if(!dialouge.getDialouge(dialougeIndex).equals(animation.getOriginalText())) {
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
