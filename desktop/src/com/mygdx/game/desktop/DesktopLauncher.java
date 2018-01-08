package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;

import javax.naming.ldap.ControlFactory;

import static com.mygdx.game.desktop.TestButton.HEIGTH;
import static com.mygdx.game.desktop.TestButton.TITLE_NAME;
import static com.mygdx.game.desktop.TestButton.WIDTH;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = TITLE_NAME;
		config.height = HEIGTH;
		config.width = WIDTH;
		new LwjglApplication(new TestButton(), config);
	}
}
