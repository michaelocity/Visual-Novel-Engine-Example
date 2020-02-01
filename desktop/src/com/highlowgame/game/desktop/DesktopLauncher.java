package com.highlowgame.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.highlowgame.game.gui.RicoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ay Que Rico";
		config.width =900;
		config.height=900;
		config.resizable=false;
		new LwjglApplication(new RicoGame(), config);
	}
}
