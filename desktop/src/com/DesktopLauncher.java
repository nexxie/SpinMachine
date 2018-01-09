package com;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import static com.TestButton.HEIGTH;
import static com.TestButton.TITLE_NAME;
import static com.TestButton.WIDTH;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = TITLE_NAME;
		config.height = HEIGTH;
		config.width = WIDTH;
		new LwjglApplication(new TestButton(), config);
	}
}
