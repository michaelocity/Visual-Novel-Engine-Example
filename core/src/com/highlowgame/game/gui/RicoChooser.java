package com.highlowgame.game.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.highlowgame.game.gui.scenes.OutsideCasino;

public class RicoChooser extends AbstractScreen{

    Texture rico5Girls;
    String title = "Who do you think she looks like?";
    Rectangle[] hitboxes = new Rectangle[5];
    Texture hitbox = new Texture("ai1.jpg");

    public RicoChooser(RicoGame game) {
        super(game);
        rico5Girls= new Texture("madoka magicapng.png");
        background = rico5Girls;
        initalizeHitboxes();
    }

    private void initalizeHitboxes()
    {
        for(int i = 0; i< hitboxes.length;i++)
        {
            hitboxes[i]=new Rectangle(RicoGame.screenResX*i/5+20, 10, (RicoGame.screenResX)/5-20,RicoGame.screenResY);
        }
    }

    @Override
    public void render(float delta) {

        begin();
        drawBackground();
        //renderHitboxes();
        drawText(title,150,800);
        end();
    }
    private void renderHitboxes()
    {
        for(int i = 0; i< hitboxes.length;i++)
        {
           drawTexture(hitbox,hitboxes[i].getX(),hitboxes[i].getY(),hitboxes[i].getWidth(),hitboxes[i].getHeight());
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
        Rectangle mouse = new Rectangle(screenX,800-screenY,5,5);
        Rectangle hit = intersects(mouse,hitboxes);
        if(hit!=null&&!mouse.equals(hit))
        {
            for (int i =0; i <hitboxes.length; i++)
            {
                if(hit.getX()==hitboxes[i].getX())
                {
                    game.girlNum=i;
                }
            }
            game.songs.stopSound();
            game.songs.stopMusic();
            game.setScreen(new OutsideCasino(game));
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
}
