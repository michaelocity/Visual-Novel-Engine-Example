package com.highlowgame.game.gui;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.highlowgame.game.actors.ScreenEffect;
import com.highlowgame.game.actors.UiButton;
import com.highlowgame.game.actors.Character;
import com.highlowgame.game.math.GameScreenMath;
import com.badlogic.gdx.scenes.scene2d.Group;


public abstract class AbstractScreen implements Screen, InputProcessor, GestureDetector.GestureListener{
    public RicoGame game;
    public static OrthographicCamera camera;
    Viewport viewport;

    String[] characters = {"Grader","Girl","Mono","Choice"};


    public Stage stage;
    public Group characterNeffects;
    public Group overlay;
    public Group buttons;


    public int dialougeIndex=0;


    Texture background;
    Texture exitButton = new Texture("buttons/exit.png");;
    Texture helpButton = new Texture("buttons/help.png");;
    Texture backButtonTexture = new Texture("buttons/backButton.png");
    Texture skipButtonTexture = new Texture("buttons/skipButton.png");
    Texture textBack = new Texture("buttons/ddlctextBAckdrop800x300.png");
    Texture upBackdrop = new Texture("backdrop/upbackdrop.png");
    Texture downBackdrop = new Texture("backdrop/downBackdrop.png");

   public UiButton exit;
   public UiButton help;

   public boolean helpMenuOpen = false;

    //ratio x to y
    private static float viewPortRatio= 1;

    float timer =0f;
    GameScreenMath math;

    private String screenName = "Ultimate Game";
    InputMultiplexer multiplexer;

    Vector2 mouseClick = new Vector2(-100,100);

    public ScreenEffect gameBackground;
    public Character girl;
    public Character person2;
    public UiButton textBackdrop;
    public UiButton effectBackdrop;
    public ScreenEffect upDimmer;
    public ScreenEffect downDimmer;
    public UiButton backButton;
    public UiButton skipButton;
    public UiButton choice1;
    public UiButton choice2;

    public boolean choiceActivated = false;
    public int choiceSelected =-1;


    public AbstractScreen(RicoGame game) {
        background = new Texture("badlogic.jpg");

        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.screenResX, game.screenResY);
        math = new GameScreenMath(camera);

        multiplexer = new InputMultiplexer();
        GestureDetector gd = new GestureDetector(this);
        viewport = new FitViewport(game.screenResX,game.screenResY, camera);
        viewport.apply();
        stage= new Stage(viewport);
        addToStageInOrder();
        initializeBasicButtons();
        multiplexer.addProcessor(gd);
        multiplexer.addProcessor(this);
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);
    }
    public void addToStageInOrder()
    {
        gameBackground=new ScreenEffect(background);

        stage.addActor(gameBackground);

        characterNeffects=new Group();
        stage.addActor(characterNeffects);

        overlay = new Group();
        stage.addActor(overlay);
        buttons = new Group();
        stage.addActor(buttons);
        textBackdrop=initButton(textBackdrop,textBack,50,0);
        upDimmer= new ScreenEffect(upBackdrop);
        downDimmer = new ScreenEffect(downBackdrop);


        if(girl!=null)
        {
            characterNeffects.addActor(girl);
        }
        if(person2!=null)
        {
            characterNeffects.addActor(person2);
        }
        if(textBackdrop!=null)
        {
            overlay.addActor(textBackdrop);
        }
        if(effectBackdrop!=null)
        {
            overlay.addActor(effectBackdrop);
        }
        if(upDimmer!=null)
        {
            overlay.addActor(upDimmer);
            upDimmer.setVisible(false);
        }
        if(downDimmer!=null)
        {
            overlay.addActor(downDimmer);
            downDimmer.setVisible(false);
        }
    }
    public void initializeBasicButtons()
    {
        exit=initButton(exit,exitButton,0,stage.getHeight()-exitButton.getHeight());
        help=initButton(help,helpButton,stage.getWidth()-helpButton.getWidth(),stage.getHeight()-helpButton.getHeight());
        backButton=initButton(backButton,backButtonTexture,0,0);
        skipButton=initButton(skipButton,skipButtonTexture,stage.getWidth()-skipButtonTexture.getWidth(),0);

    }
    public UiButton initButton(UiButton button, Texture buttonTexture,float xPos, float ypos)
    {
        button = new UiButton(buttonTexture,xPos,ypos);
        buttons.addActor(button);
        button.setTouchable(Touchable.enabled);
        return button;
    }

    public void drawMCText(String text)
    {
        game.font.setColor(Color.BLUE);
        drawDialouge(text);
    }
    public void drawGirlText(String text)
    {
        game.font.setColor(Color.PURPLE);
        drawDialouge(text);
    }
    public void drawGirlName(String text)
    {
        if(game.girlNum>-1)
        {
            drawName(game.girlNames[game.girlNum]);
        }
        else
        {
            drawName(text);
        }
    }
    public void drawMonolouge(String text)
    {
        game.font.setColor(Color.ROYAL);
        drawDialouge(text);
    }
    public void drawChoice(String text)
    {
        game.font.setColor(Color.RED);
        drawDialouge(text);
    }
    public void drawUnknown(String text)
    {
        game.font.setColor(Color.BLACK);
        drawDialouge(text);
    }
    public void drawCorrectDialouge(String character, String dialouge)
    {

        if(character.equals(characters[0]))
        {
            drawMCText(dialouge);
            drawName(characters[0]);
        }
        else if(character.equals(characters[1]))
        {
            drawGirlText(dialouge);
            drawGirlName(characters[1]);
        }
        else if(character.equals(characters[2]))
        {
            drawMonolouge(dialouge);
            drawName(characters[0]);
        }
        else if(character.equals(characters[3]))
        {
            drawChoice(dialouge);
            drawName(characters[3]);
        }
        else
        {

            drawUnknown(dialouge);
            drawName(character);
        }

    }
    public void drawBackground()
    {
        stage.getBatch().draw(background,0,0,camera.viewportWidth,camera.viewportHeight);
    }

    public void drawText(String text,int x, int y)
    {
        game.font.draw(stage.getBatch(),text,x,y);
    }

    public void drawTexture(Texture texture, float x, float y, float width, float height)
    {
        stage.getBatch().draw(texture,x,y,width,height);
    }

    public Rectangle intersects(Rectangle hitbox, Rectangle[] buttonHitboxes)
    {
        for (int anime = 0; anime<buttonHitboxes.length;anime++)
        {
            if(hitbox.overlaps(buttonHitboxes[anime]))
            {
                return buttonHitboxes[anime];
            }
        }
        return hitbox;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        stage.draw();
        if(helpMenuOpen)
        {
            renderHelpMenu();
        }
        game.batch.end();
        checkForButtonClicks();
    }
    public void renderHelpMenu()
    {
        if(helpMenuOpen) {
            drawText("default text for help menu," +
                    "\n help button cliccked:" + helpMenuOpen, 100, 500);
        }
    }

    public void drawName(String name)
    {
        game.font.getData().setScale(1.5f);
        drawText(name, 90, 270);
        game.font.getData().setScale(2f);
    }
    public void drawDialouge(String name)
    {
        game.font.getData().setScale(1.8f);
        drawText(name, 60, 210);
        game.font.getData().setScale(2f);
    }

    //if any button is being clicked, return yes
    public boolean checkForButtonClicks()
    {
        if(exit.isClicked())
        {
            exit.setClicked(false);
            Gdx.app.exit();
        }
        else if(help.isClicked())
        {
            helpMenuOpen=!helpMenuOpen;
            help.setClicked(false);
        }
        else if(textBackdrop.isClicked()&&!choiceActivated)
        {
            dialougeIndex++;
            textBackdrop.setClicked(false);
        }
        else if(backButton.isClicked()&&dialougeIndex>0&&!choiceActivated)
        {
            dialougeIndex--;
            backButton.setClicked(false);
        }
        else if(skipButton.isClicked()&&!choiceActivated)
        {
            skipText();
            skipButton.setClicked(false);
        }
        return false;
    }
    public void updateAnimatedText()
    {

    }
    public void skipText()
    {

    }


    @Override
    public void resize(int width, int height) {

        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
        camera.update();
        math.updateSizes(viewport);

        math.setBlockWidth(viewport.getScreenWidth());
        math.setBlockHeight(viewport.getScreenHeight());
    }
    public void begin()
    {
        stage.getBatch().begin();
    }
    public void end()
    {
        stage.getBatch().end();
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
    public void batchUpdate()
    {
        game.batch.setTransformMatrix(camera.view);
        game.batch.setProjectionMatrix(camera.projection);
    }

    public void abstractDispose() {
        background.dispose();
        exitButton.dispose();
        helpButton.dispose();
    }

    @Override
    public void dispose() {
        abstractDispose();
    }

    public RicoGame getGame() {
        return game;
    }

    public void setGame(RicoGame game) {
        this.game = game;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public GameScreenMath getMath() {
        return math;
    }

    public void setMath(GameScreenMath math) {
        this.math = math;
    }

    public Vector2 getMouseClick() {
        return mouseClick;
    }

    public void setMouseClick(Vector2 mouseClick) {
        this.mouseClick = mouseClick;
    }



}
