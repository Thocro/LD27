package com.thocro.ld27.game;

import java.util.Random;

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

	public static final int MODE_DEAD = 0x10c;

	public Level level1, level2;
	public Player player;
	private int currentLevel = 1;

	private float swapTimer;

	public boolean paused = false, internallyPaused = false;

	public InGameUI ui;

	public boolean playerDead = false;

	public int currentStage = 1;
	public int currentSwap = 0;

	public int mode;

	public void enter() {
		Gdx.input.setInputProcessor(this);
		level1 = new Level(11, 10);
		level2 = new Level(11, 10);
		player = new Player(10, 10, level1);
		level1.add(player);
		ui = new InGameUI();
		Font.load();
		addZombie(5);
	}

	Random rand = new Random();

	private void addZombie(int i) {
		for (int j = 0; j < i; j++) {
			level1.entities.add(new Zombie(rand.nextInt(250), rand.nextInt(250), level1));
		}
	}

	public void exit() {

	}

	public void render(SpriteBatch sb) {
		level1.render(sb, 10, 10);
		level2.render(sb, 436, 10);

		Font.draw("FPS: " + Gdx.graphics.getFramesPerSecond(), sb, 0, Game.HEIGHT - 16, 16);
		Font.draw("TIME: " + (int) swapTimer, sb, 300, Game.HEIGHT - 32, 16);
		Font.draw("HEALTH: " + player.health, sb, 500, Game.HEIGHT - 32, 16);

		
		ui.renderOverlay(sb, this);

		if (playerDead) {
			ui.renderDeathScreen(sb);
		}
		
		if (paused) {
			ui.renderPauseScreen(sb);
		}
	}

	public void update(float delta) {
		if (!paused && !internallyPaused) {
			pollInput(delta);
			level1.update(delta);
			level2.update(delta);

			swapTimer += delta;
			if (swapTimer >= 10) {
				swapPlayer();
				swapTimer -= 10;
			}
		}

		if (currentLevel == 2) {
			if (player.health < player.maxHealth) {
				healthIncrement += 0.2f;
				if (healthIncrement >= 1f) {
					player.health++;
					healthIncrement -= 1f;
				}
			}
		}

		if (player.dead) {
			playerDied();
			mode = MODE_DEAD;
		}
	}

	public void playerDied() {
		playerDead = true;
		internallyPaused = true;
	}

	float healthIncrement;

	public void pollInput(float delta) {

	}

	private void resetGame() {
		level1 = new Level(11, 10);
		level2 = new Level(11, 10);
		player = new Player(10, 10, level1);
		level1.add(player);
		ui = new InGameUI();
		Font.load();
		addZombie(5);
		mode = 0;
		currentStage = 1;
		currentSwap = 0;
		currentLevel = 1;
		playerDead = false;
		internallyPaused = false;
		paused = false;
		swapTimer = 0;
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

			currentSwap++;
			if (currentSwap < 5) {
				addZombie(2);
			} else if (currentSwap < 10) {
				addZombie(3);
			}
		}
		System.out.println("Player swapped to level " + currentLevel);
	}

	public Level getCurrentLevel() {
		if (currentLevel == 1) {
			return level1;
		} else if (currentLevel == 2) {
			return level2;
		}
		return null;
	}

	public String getName() {
		return "In Game";
	}

	public boolean keyDown(int keycode) {
		if (keycode == Keys.ESCAPE) {
			if (mode == MODE_DEAD) {
				resetGame();
			} else {
				paused = !paused;
			}
			return true;
		} else if (keycode == Keys.SPACE) {
			getCurrentLevel().getPlayer().attack(getCurrentLevel());
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
