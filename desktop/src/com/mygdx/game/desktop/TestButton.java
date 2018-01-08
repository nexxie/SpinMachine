package com.mygdx.game.desktop;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TestButton implements ApplicationListener {
    public static final int WIDTH = 800;
    public static final int HEIGTH = 800;
    public static final String TITLE_NAME = "Slot Machine by Yaroslav Vakhov.";

    private Viewport viewport;
    private Stage stage;
    private Skin skin;
    private TextureAtlas textureAtlas;
    private Texture backGround;
    private Animation<TextureRegion> spinAnimation;
    private Animation<TextureRegion> spin2Animation;
    private Animation<TextureRegion> spin3Animation;
    private SpriteBatch sb;
    private float elepsedTime = 0f;
    private BitmapFont font;
    private SpriteBatch batch;
    private String fs;
    private TextButton button;
    private OrthographicCamera gameCame;


    @Override
    public void create() {
        gameCame = new OrthographicCamera();
        viewport = new StretchViewport(800   , 800,gameCame);

        font = new BitmapFont();
        batch = new SpriteBatch();


        sb = new SpriteBatch();
        backGround = new Texture("bear.jpg");

        textureAtlas = new TextureAtlas("pack.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());

        spinAnimation = new Animation<TextureRegion>(0 / 0f, textureAtlas.getRegions());
        spin2Animation = new Animation<TextureRegion>(0 / 0f, textureAtlas.getRegions());
        spin3Animation = new Animation<TextureRegion>(0 / 0f, textureAtlas.getRegions());

        button = new TextButton("Start", skin, "default");



        button.setWidth(220);
        button.setHeight(50);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {



                spinAnimation.setFrameDuration(0.2f);
                spin2Animation.setFrameDuration(0.3f);
                spin3Animation.setFrameDuration(0.5f);


                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spin2Animation.setFrameDuration(0.0f);

                    }
                },6);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spinAnimation.setFrameDuration(0.0f);
                    }


                }, 3);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        System.out.println(spinAnimation.getPlayMode());
                        spin3Animation.setFrameDuration(0.0f);
                    }


                }, 4);


            }
        });

        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render() {

        elepsedTime += Gdx.graphics.getDeltaTime();


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT);

        sb.begin();
        Dialog d = new Dialog(String.valueOf(Gdx.graphics.getFramesPerSecond()),skin);
        sb.draw(spinAnimation.getKeyFrame(elepsedTime, true), 50, 60);
        sb.draw(spin2Animation.getKeyFrame(elepsedTime, true), 200, 60);
        sb.draw(spin3Animation.getKeyFrame(elepsedTime, true), 350, 60);
        font.draw(
                sb,
                "FPS: " + Gdx.graphics.getFramesPerSecond(),
                10,
                viewport.getScreenHeight() - 44);

        sb.end();
        stage.draw();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        sb.dispose();
        textureAtlas.dispose();
        stage.dispose();

    }
}
