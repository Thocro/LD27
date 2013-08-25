package com.thocro.ld27.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.Game;
import com.thocro.ld27.entity.mob.Player;
import com.thocro.ld27.entity.mob.SandWarrior;
import com.thocro.ld27.entity.mob.Zombie;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;
import com.thocro.ld27.shop.ArmourShop;
import com.thocro.ld27.shop.WeaponShop;
import com.thocro.ld27.sound.SoundManager;
import com.thocro.ld27.state.State;
import com.thocro.ld27.story.StoryManager;
import com.thocro.ld27.ui.InGameUI;

public class GameState implements State, InputProcessor {

	public static final int MODE_DEAD = 0x10c;

	public Level level1, level2;
	public Player player;
	private int currentLevel = 2;

	public float swapTimer;

	public boolean paused = false, internallyPaused = false;

	public InGameUI ui;

	public boolean playerDead = false;

	public int currentStage = 1;
	public int currentSwap = 1;

	public int mode;

	public WeaponShop wShop;
	public ArmourShop aShop;

	public StoryManager story;

	public void enter() {
		Gdx.input.setInputProcessor(this);
		level1 = new Level(11, 11);
		level2 = new Level(11, 7);
		player = new Player(10, 10, level2);
		player.money = 0;
		level2.add(player);
		ui = new InGameUI();
		story = new StoryManager();
		Font.load();
		addZombie(5);
		addSandWarrior(1);
		wShop = new WeaponShop(200, 0, level2);
		aShop = new ArmourShop(100, 0, level2);

		SoundManager.load();
	}

	Random rand = new Random();

	private void addZombie(int i) {
		for (int j = 0; j < i; j++) {
			level1.entities.add(new Zombie(rand.nextInt(250), rand.nextInt(250), level1));
		}
	}

	private void addSandWarrior(int i) {
		for (int j = 0; j < i; j++) {
			level1.entities.add(new SandWarrior(rand.nextInt(250), rand.nextInt(250), level1));
		}
	}

	public void exit() {

	}

	public void render(SpriteBatch sb) {
		renderBg(sb);
		level1.render(sb, 32, 32);
		level2.render(sb, 32 * 13, 160);
		wShop.render(sb, 32 * 13, 160);
		aShop.render(sb, 32 * 13, 160);

		Font.draw("STAGE: " + currentStage, sb, 500, Game.HEIGHT - 20, 16);

		Font.draw("LEVEL: " + currentSwap, sb, 650, Game.HEIGHT - 20, 16);

		ui.renderOverlay(sb, this);
		story.render(sb, 450, 30);

		if (playerDead) {
			ui.renderDeathScreen(sb);
		}

		if (paused) {
			ui.renderPauseScreen(sb);
		}

		if (aShop.open) {
			if (!internallyPaused) {
				internallyPaused = true;
			} else {
				ui.renderArmourShop(sb, this);
			}
		}
		if (wShop.open) {
			if (!internallyPaused) {
				internallyPaused = true;
			} else {
				ui.renderWeaponShop(sb, this);
			}
		}
	}

	private TextureRegion wall1 = new TextureRegion(Tile.tileSheet, 7 * 8, 1 * 8, 8, 8);
	private TextureRegion wall2 = new TextureRegion(Tile.tileSheet, 8 * 8, 1 * 8, 8, 8);
	private TextureRegion wallCorner1 = new TextureRegion(Tile.tileSheet, 9 * 8, 1 * 8, 8, 8);
	private TextureRegion wallCorner2 = new TextureRegion(Tile.tileSheet, 10 * 8, 1 * 8, 8, 8);
	private TextureRegion wallCorner3 = new TextureRegion(Tile.tileSheet, 11 * 8, 1 * 8, 8, 8);
	private TextureRegion wallCorner4 = new TextureRegion(Tile.tileSheet, 12 * 8, 1 * 8, 8, 8);
	private TextureRegion wallJoint1 = new TextureRegion(Tile.tileSheet, 13 * 8, 1 * 8, 8, 8);
	private TextureRegion wallJoint2 = new TextureRegion(Tile.tileSheet, 14 * 8, 1 * 8, 8, 8);

	private void renderBg(SpriteBatch sb) {
		// Middle Wall
		for (int i = 0; i < 11; i++) {
			sb.draw(wall1, 12 * 32, 32 + (i * 32), 32, 32);
		}
		for (int i = 0; i < 7; i++) {
			sb.draw(wall1, 24 * 32, 160 + (i * 32), 32, 32);
		}
		for (int i = 0; i < 7; i++) {
			sb.draw(wall1, 24 * 32, 160 + (i * 32), 32, 32);
		}
		for (int i = 0; i < 11; i++) {
			sb.draw(wall1, 0 * 32, 32 + (i * 32), 32, 32);
		}
		for (int i = 0; i < 11; i++) {
			sb.draw(wall2, 32 + (i * 32), 0, 32, 32);
		}
		for (int i = 0; i < 11; i++) {
			sb.draw(wall2, 32 + (i * 32), 12 * 32, 32, 32);
		}
		for (int i = 0; i < 11; i++) {
			sb.draw(wall2, 13 * 32 + (i * 32), 160 - 32, 32, 32);
		}
		for (int i = 0; i < 11; i++) {
			sb.draw(wall2, 13 * 32 + (i * 32), 160 + 7 * 32, 32, 32);
		}
		sb.draw(wallCorner1, 0, 12 * 32, 32, 32);
		sb.draw(wallCorner3, 0, 0, 32, 32);
		sb.draw(wallCorner4, 12 * 32, 0, 32, 32);
		sb.draw(wallCorner4, 24 * 32, 160 - 32, 32, 32);
		sb.draw(wallCorner2, 24 * 32, 12 * 32, 32, 32);
		sb.draw(wallJoint1, 12 * 32, 12 * 32, 32, 32);
		sb.draw(wallJoint2, 12 * 32, 4 * 32, 32, 32);
	}

	public void update(float delta) {
		updateSound();
		story.update(delta, this);

		if (!paused && !internallyPaused) {
			pollInput(delta);
			level1.update(delta);
			level2.update(delta);

			swapTimer += delta;
			if (swapTimer >= 10) {
				swapPlayer();
				swapTimer -= 10;
			}

			wShop.update(delta, level2);
			aShop.update(delta, level2);

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

	}

	private void updateSound() {
		if (rand.nextInt(100) == 1) {
			SoundManager.zombie1.play();
		}
		if (rand.nextInt(500) == 1) {
			SoundManager.zombie2.play(0.5f);
		}
		if (rand.nextInt(200) == 1) {
			SoundManager.zombie3.play();
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
		Gdx.input.setInputProcessor(this);
		level1 = new Level(11, 11);
		level2 = new Level(11, 7);
		player = new Player(10, 10, level2);
		player.money = 0;
		level2.add(player);
		ui = new InGameUI();
		story = new StoryManager();
		Font.load();
		addZombie(5);
		addSandWarrior(1);
		wShop = new WeaponShop(200, 0, level2);
		aShop = new ArmourShop(100, 0, level2);

		mode = 0;
		currentStage = 1;
		currentSwap = 1;
		currentLevel = 2;
		playerDead = false;
		internallyPaused = false;
		paused = false;
		swapTimer = 0;
	}

	public void swapPlayer() {
		if (currentLevel == 1) {
			level1.remove(player);
			player.level = level2;
			player.x = 100;
			level2.add(player);
			currentLevel = 2;

			currentSwap++;
			if (currentSwap > 5) {
				currentStage++;
				currentSwap = 1;
			}
			if (currentStage == 1) {
				addZombie(3);
				addSandWarrior(1);
				player.money += 20;
			} else if (currentStage == 2) {
				addZombie(5);
				addSandWarrior(2);
				player.money += 30;
			} else if (currentStage == 3) {
				addZombie(7);
				addSandWarrior(4);
				player.money += 40;
			} else {
				addZombie(10);
				addSandWarrior(5);
				player.money += 50;

			}
		} else if (currentLevel == 2) {
			level2.remove(player);
			player.level = level1;
			level1.add(player);
			currentLevel = 1;

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
		story.keyPressed(keycode);
		if (keycode == Keys.ESCAPE || keycode == Keys.DEL) {
			if (mode == MODE_DEAD) {
				resetGame();
			} else if (aShop.open) {
				aShop.open = false;
				internallyPaused = false;
				player.y = 70;
				player.x = 90;

			} else if (wShop.open) {
				wShop.open = false;
				internallyPaused = false;
				player.y = 70;
				player.x = 190;

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
		screenY = Game.HEIGHT - screenY;
		if (aShop.open) {
			if (ui.aRust.contains(screenX, screenY)) {
				int cost = 100;
				if (player.money >= cost) {
					player.money -= cost;
					player.defence = 15;
					player.armour = 1;
					System.out.println("Player Bought Rusty Shield");
				}
			} else if (ui.aIron.contains(screenX, screenY)) {
				int cost = 250;
				if (player.money >= cost) {
					player.money -= cost;
					player.defence = 20;
					player.armour = 2;
					System.out.println("Player Bought Iron Shield");
				}
			} else if (ui.aGold.contains(screenX, screenY)) {
				int cost = 400;
				if (player.money >= cost) {
					player.money -= cost;
					player.defence = 25;
					player.armour = 3;
					System.out.println("Player Bought Gold Shield");
				}
			}
		} else if (wShop.open) {
			if (ui.wRust.contains(screenX, screenY)) {
				int cost = 100;
				if (player.money >= cost) {
					player.money -= cost;
					player.attack = 50;
					player.weapon = 1;
					System.out.println("Player Bought Rusty Sword");
				}
			} else if (ui.wIron.contains(screenX, screenY)) {
				int cost = 250;
				if (player.money >= cost) {
					player.money -= cost;
					player.attack = 75;
					player.weapon = 2;
					System.out.println("Player Bought Iron Sword");
				}
			} else if (ui.wGold.contains(screenX, screenY)) {
				int cost = 400;
				if (player.money >= cost) {
					player.money -= cost;
					player.attack = 100;
					player.weapon = 3;
					System.out.println("Player Bought Gold Sword");
				}
			}
		}
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
