package com.thocro.ld27;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		Game game = new Game();
		cfg.title = Game.TITLE;
		cfg.useGL20 = false;
		cfg.width = Game.WIDTH;
		cfg.height = Game.HEIGHT;
		cfg.fullscreen = Game.FULLSCREEN;
		cfg.resizable = false;

		new LwjglApplication(game, cfg);
	}
}
