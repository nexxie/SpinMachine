package com;

import com.badlogic.gdx.*;
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

import java.util.*;

public class TestButton implements ApplicationListener {
    public static final int WIDTH = 800;
    public static final int HEIGTH = 800;
    public static final String TITLE_NAME = "Slot Machine by Yaroslav Vakhov.";


    private float minFrameDuraction = 0.1f;   //
    private float maxFrameDuraction = 0.6f;   //

    private Viewport viewport;

    private Stage stage;
    private Skin skin;

    private TextureAtlas textureAtlas;
    private Texture backGround;

    private Animation<TextureRegion> spinAnimation;
    private Animation<TextureRegion> spin2Animation;
    private Animation<TextureRegion> spin3Animation;
    private Animation<TextureRegion> spin4Animation;
    private Animation<TextureRegion> spin5Animation;
    private float startSpinDuraction = 0 / 0f;
    private SpriteBatch sb;
    private float elepsedTime = 0f;
    private BitmapFont font;
    private TextButton button;
    private OrthographicCamera gameCame;


    @Override
    public void create() {


        gameCame = new OrthographicCamera();
        viewport = new StretchViewport(800, 800, gameCame);

        font = new BitmapFont();


        sb = new SpriteBatch();
        backGround = new Texture("bear.jpg");

        textureAtlas = new TextureAtlas("pack.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());


        spinAnimation = new Animation<TextureRegion>(startSpinDuraction, textureAtlas.getRegions());
        spin2Animation = new Animation<TextureRegion>(startSpinDuraction, textureAtlas.getRegions());
        spin3Animation = new Animation<TextureRegion>(startSpinDuraction, textureAtlas.getRegions());
        spin4Animation = new Animation<TextureRegion>(startSpinDuraction, textureAtlas.getRegions());
        spin5Animation = new Animation<TextureRegion>(startSpinDuraction, textureAtlas.getRegions());


        //Реализация кнопки
        button = new TextButton("Start", skin, "default");
        button.setWidth(220);
        button.setHeight(50);


        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                // Скорость прокрутки спинов в диапозоне
                spinAnimation.setFrameDuration(randFloat(minFrameDuraction, maxFrameDuraction));
                spin2Animation.setFrameDuration(randFloat(minFrameDuraction, maxFrameDuraction));
                spin3Animation.setFrameDuration(randFloat(minFrameDuraction, maxFrameDuraction));
                spin4Animation.setFrameDuration(randFloat(minFrameDuraction, maxFrameDuraction));
                spin5Animation.setFrameDuration(randFloat(minFrameDuraction, maxFrameDuraction));

                ArrayList<Integer> rand = getRandomNumber();
                //Получение случайных значений из коллекции по порядку
                int a = rand.get(rand.get(0));
                int b = rand.get(rand.get(1));
                int c = rand.get(rand.get(2));
                int d = rand.get(rand.get(3));
                int e = rand.get(rand.get(4));


                System.out.println(a);
                System.out.println(b);
                System.out.println(c);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spinAnimation.setFrameDuration(0.0f);
                    }
                }, a);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spin2Animation.setFrameDuration(0.0f);
                    }
                }, b);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spin3Animation.setFrameDuration(0.0f);
                    }
                }, c);

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spin4Animation.setFrameDuration(0.0f);
                    }
                }, d);


                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        spin5Animation.setFrameDuration(0.0f);
                    }
                }, e);


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
        sb.draw(backGround,0,0,TestButton.WIDTH,TestButton.HEIGTH);
        sb.draw(spinAnimation.getKeyFrame(elepsedTime, true), 50, 60);
        sb.draw(spin2Animation.getKeyFrame(elepsedTime, true), 200, 60);
        sb.draw(spin3Animation.getKeyFrame(elepsedTime, true), 350, 60);
        sb.draw(spin4Animation.getKeyFrame(elepsedTime, true), 500, 60);
        sb.draw(spin5Animation.getKeyFrame(elepsedTime, true), 650, 60);


        //Отображение FPS
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

    // Рандомное значение FrameDuration
    public static float randFloat(float min, float max) {

        Random rand = new Random();

        float result = rand.nextFloat() * (max - min) + min;

        return result;

    }


    //Запись и сортировка рандомных значений длительности спина (от 1 -5)
    private ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> numbersGenerated = new ArrayList<Integer>();

        for (int i = 0; i < 6; i++) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(6);

            if (!numbersGenerated.contains(iNumber)) {
                numbersGenerated.add(iNumber);
            } else {
                i--;
            }
        }
        Collections.sort(numbersGenerated);

        return numbersGenerated;
    }
}


