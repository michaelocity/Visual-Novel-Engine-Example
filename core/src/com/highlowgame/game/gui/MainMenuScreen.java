package com.highlowgame.game.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.gui.scenes.InsideSchool;
import com.highlowgame.game.math.TextAnimation;

public class MainMenuScreen extends AbstractScreen {

    String backgroundTexture = "sword_art_online800quality.jpg";
    String title = "Ay Que Rico";

    TextAnimation titleText;

    Texture playButton= new Texture("playButton.png");

    public MainMenuScreen(RicoGame game)
    {
        super(game);
        background = new Texture(backgroundTexture);
        System.out.println("rendered");
        gameBackground.setEffectSprite(background);
        game.font.setColor(Color.GOLDENROD);
        game.font.getData().setScale(5f);
        help.setVisible(false);
        skipButton.setVisible(false);
        backButton.setVisible(false);
        textBackdrop.setVisible(false);
        titleText = new TextAnimation(title,0.5f);
        game.songs.playMusicMainMenu();
    }

    @Override
    public void render(float delta) {
        game.font.setColor(Color.GOLDENROD);
        game.font.getData().setScale(5f);
        titleText.animateTyping(delta);
        batchUpdate();
        stage.draw();
        stage.getBatch().begin();
        drawTexture(playButton,(RicoGame.screenResX-playButton.getWidth())/2,RicoGame.screenResY/2-playButton.getHeight()/2,playButton.getWidth(),playButton.getHeight());
        drawText(titleText.getEdited(),RicoGame.screenResX/2-200,RicoGame.screenResY/2+300);
        drawText("Thanks So Much To: Gaby,\n Julian,\n Madelyn,\n and many others",RicoGame.screenResX/2-450,RicoGame.screenResY/2-100);
        stage.getBatch().end();
        checkForButtonClicks();
        //test.animateTyping(delta);

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
        if(checkForPlayButton(new Vector2(screenX,RicoGame.screenResY-screenY)))
        {
            System.out.println("TOuched At:"+screenX+", "+(RicoGame.screenResY-screenY));
            game.songs.stopMusic();
            game.setScreen(new InsideSchool(game));
            dispose();
        }
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

    @Override
    public void dispose() {
        playButton.dispose();
        background.dispose();
    }

    private boolean checkForPlayButton(Vector2 hitboxStart)
    {
        Texture temp = playButton;
        Rectangle mouse = new Rectangle(hitboxStart.x, hitboxStart.y, 5, 5);
        Rectangle playButton = new Rectangle((RicoGame.screenResX-temp.getWidth())/2,RicoGame.screenResY/2-temp.getHeight()/2,temp.getWidth(),temp.getHeight());
        return mouse.overlaps(playButton);
    }


}
