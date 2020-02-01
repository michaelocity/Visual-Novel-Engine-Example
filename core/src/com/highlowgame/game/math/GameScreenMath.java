package com.highlowgame.game.math;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.highlowgame.game.gui.RicoGame;


public class GameScreenMath {
    private float blockWidth =1;
    private float blockHeight =1;
    private Vector2 correctedXY = new Vector2();;
    private int screenResX = RicoGame.screenResX;
    private int screenResY = RicoGame.screenResY;

    public GameScreenMath(Camera camera)
    {
        blockWidth = camera.viewportWidth*1.0f/screenResX;
        blockHeight = camera.viewportHeight*1.0f/screenResY;
    }

    public float getBlockWidth() {
        return blockWidth;
    }

    public void setBlockWidth(float blockWidth) {
        this.blockWidth = blockWidth*1.0f/screenResX;
    }

    public float getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(float blockHeight) {
        this.blockHeight = blockHeight*1.0f/screenResY;
    }

    public void updateSizes(Viewport viewport)
    {
        blockHeight= ((Gdx.graphics.getHeight()-viewport.getBottomGutterHeight()-viewport.getTopGutterHeight())/screenResY);
        blockWidth = ((Gdx.graphics.getWidth()-viewport.getLeftGutterWidth()-viewport.getRightGutterWidth())/screenResX);
    }


    public Vector2 correctedXY(int screenX, int screenY, Viewport viewport, Camera camera)
    {

        float yScale = 1f;
        float xScale = 1f;
        float width=0, height =0;
        Vector2 temp;

        //checks to see if it is scalled smaller
            yScale = viewport.getScreenHeight()/camera.viewportHeight;

            xScale = viewport.getScreenWidth()/camera.viewportWidth;

        if (camera.viewportWidth>viewport.getScreenWidth())
        {
            height= (screenY - viewport.getBottomGutterHeight())/yScale;
            width = (screenX - viewport.getScreenX())/xScale;
        }
        if (camera.viewportHeight>viewport.getScreenHeight())
        {
            height= (screenY - viewport.getBottomGutterHeight());
            width = (screenX - viewport.getScreenX())/xScale;
        }
        else if (camera.viewportWidth<viewport.getScreenWidth())
        {
             width = (screenX - viewport.getScreenX());
             height = (screenY - viewport.getScreenY());
        }
        temp = new Vector2(width, height);
        if(temp.x<0||temp.x>screenResX)
        {
            temp.x=0;
        }
        if(temp.y<0||temp.y>screenResY)
        {
           // temp.y=0;
        }
        return temp;
    }

}
