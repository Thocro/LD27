package com.thocro.ld27.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.Game;
import com.thocro.ld27.entity.mob.Player;
import com.thocro.ld27.entity.mob.Zombie;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.state.State;
import com.thocro.ld27.ui.InGameUI;

public class GameState implements State, InputProcessor {

	public Level level1, level2;
	public Player player;
	private int currentLevel = 1;

	private float swapTimer;

	public boolean paused = false;

	public InGameUI ui;

	public void enter() {
		Gdx.input.setInputProcessor(this);
		level1 = new Level(11, 10);
		level2 = new Level(11, 10);
		player = new Player(10, 10, level1);
		level1.add(player);
		for (int i = 0; i < 100; i++)
			level1.entities.add(new Zombie(10, 10, level1));
		ui = new InGameUI();
		Font.load();
	}

	public void exit() {

	}

	public void render(SpriteBatch sb) {
		level1.render(sb, 10, 10);
		level2.render(sb, 436, 10);

		Font.draw("FPS: " + Gdx.graphics.getFramesPerSecond(), sb, 0, Game.HEIGHT - 16, 16);
		Font.draw("TIME: " + (int) swapTimer, sb, 300, Game.HEIGHT - 32, 16);

		if (paused) {
			ui.renderPauseScreen(sb);
		}
	}

	public void update(float delta) {
		if (!paused) {
			pollInput(delta);
			level1.update(delta);
			level2.update(delta);

			swapTimer += delta;
			if (swapTimer >= 10) {
				swapPlayer();
				swapTimer -= 10;
			}
		}
	}

	public void pollInput(float delta) {

	}

	public void swapPlayer() {
		if (currentLevel == 1) {
			level1.remove(player);
			player.level = level2;
			level2.add(player);
			currentLevel = 2;
		} else if (currentLevel == 2) {
			level2.remove(player);
			player.level = level1;
			level1.add(player);
			currentLevel = 1;
		}
		System.out.println("Player swapped to level " + currentLevel);
	}

	public String getName() {
		return "In Game";
	}

	public boolean keyDown(int keycode) {
		if (keycode == Keys.ESCAPE) {
			paused = !paused;
			System.out.println("Escaspe!");
			return true;
		}
		return false;
	}

	public boolean keyUp(int keycode) {
		return false;
	}

	public boolean keyTyped(char character) {
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	public boolean scrolled(int amount) {
		return false;
	}

}
