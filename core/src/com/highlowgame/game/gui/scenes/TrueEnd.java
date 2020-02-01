package com.highlowgame.game.gui.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.actors.Character;
import com.highlowgame.game.gui.AbstractScreen;
import com.highlowgame.game.gui.MainMenuScreen;
import com.highlowgame.game.gui.RicoGame;
import com.highlowgame.game.gui.dialouge.TrueEndDialouge;
import com.highlowgame.game.math.TextAnimation;

public class TrueEnd extends AbstractScreen {
    Texture background = new Texture("backgrounds/badroom.jpg");
    TrueEndDialouge dialouge = new TrueEndDialouge();
    TextAnimation animation = new TextAnimation("");
    Texture girlTexture = new Texture("ricoChoice.png");
    boolean charCreated =false;


    public TrueEnd(RicoGame game) {
        super(game);
        game.font.setColor(Color.BLUE);
        gameBackground.setEffectSprite(background);

        game.songs.playLoveMusic();
        game.songs.playRicoEnding();
    }

    @Override
    public void render(float delta) {
        checkForInBounds();
        updateAnimatedText();
        animation.animateTyping(delta);
        stage.draw();
        stage.getBatch().begin();
        drawCorrectDialouge(dialouge.getCharacter(dialougeIndex), animation.getEdited());
        renderHelpMenu();
        stage.getBatch().end();
        checkForButtonClicks();
        checkFotRightTurn();
    }

    private void checkFotRightTurn()
    {
        if(dialougeIndex==11&&!charCreated)
        {
            game.songs.stopMusic();
            game.songs.playDangerMusic();
            girl= new Character(girlTexture,0,0);
            characterNeffects.addActor(girl);
            girl.setVisible(true);
            charCreated=true;
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
            drawText("You Reached THe End of the Game" +
                    "\nCongrats" +
                    "\nThere are still more ending to find so " +
                    "\nkeep on Playing", 100, 500);
            game.font.setColor(Color.BLUE);
        }
    }

    private void checkForInBounds() {
        if (dialougeIndex > dialouge.size() - 1) {
            dialougeIndex = dialouge.size() - 1;
            game.songs.stopMusic();
            game.songs.stopSound();
            game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void updateAnimatedText() {

        if (!dialouge.getDialouge(dialougeIndex).equals(animation.getOriginalText())) {
            if(dialouge.getCharacter(dialougeIndex).equals("Choice"))
            {
                animation = new TextAnimation(dialouge.getDialouge(dialougeIndex),5f);
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
