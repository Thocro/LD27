package com.thocro.ld27;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		Game game = new Game();
		cfg.title = game.TITLE;
		cfg.useGL20 = false;
		cfg.width = game.WIDTH;
		cfg.height = game.HEIGHT;
		cfg.fullscreen = game.FULLSCREEN;

		new LwjglApplication(game, cfg);
	}
}
