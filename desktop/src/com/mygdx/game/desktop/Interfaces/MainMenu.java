/*
package com.mygdx.game.desktop.Interfaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.lwjgl.opengl.GL20;

public class MainMenu implements Screen{
    private Stage stage;
    private Table table;
    private TextButton startButton;
    private Label heading;
    private Skin skin;
    private BitmapFont white,black;
    private TextureAtlas textureAtlas;


    @Override
    public void show() {


        //textureAtlas = new TextureAtlas("atlas.pack");
        skin = new Skin(Gdx.files.internal("menuSkin.json"));
        stage = new Stage(new ScreenViewport());

        final TextButton button = new TextButton("Start",skin , "default");
        button.setWidth(220);
        button.setHeight(50);

        final Dialog dialog = new Dialog("Start mess",skin);

        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);

      */
/*  table = new Table(skin);
        table.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
*//*

       // black = new BitmapFont(Gdx.files.internal("font/blac16.fnt"), false);
       // white = new BitmapFont(Gdx.files.internal("font/white16.fnt"),false);

*/
/*       *//*
*/
/* TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button.up");
        textButtonStyle.down = skin.getDrawable("button.down");
        textButtonStyle.pressedOffsetX =1;*//*
*/
/*

        textButtonStyle.checkedOffsetY = -1;
        textButtonStyle.font = black;

        startButton = new TextButton("Start",textButtonStyle);
        startButton.pad(20);//Отступ в кнопке надписи от границы кнопки*//*


       // table.add(startButton);

       // stage.addActor(table);



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());

        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

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

    @Override
    public void dispose() {

    }
}
*/
