package com.thocro.ld27.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.Game;
import com.thocro.ld27.game.GameState;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.tile.Tile;

public class InGameUI {

	private TextureRegion guiCorner1 = new TextureRegion(Tile.tileSheet, 0, 12 * 8, 8, 8);
	private TextureRegion guiCorner2 = new TextureRegion(Tile.tileSheet, 1 * 8, 12 * 8, 8, 8);
	private TextureRegion guiCorner3 = new TextureRegion(Tile.tileSheet, 2 * 8, 12 * 8, 8, 8);
	private TextureRegion guiCorner4 = new TextureRegion(Tile.tileSheet, 3 * 8, 12 * 8, 8, 8);

	private TextureRegion guiEdge1 = new TextureRegion(Tile.tileSheet, 4 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge2 = new TextureRegion(Tile.tileSheet, 5 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge3 = new TextureRegion(Tile.tileSheet, 6 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge4 = new TextureRegion(Tile.tileSheet, 7 * 8, 12 * 8, 8, 8);

	private TextureRegion guiFill = new TextureRegion(Tile.tileSheet, 8 * 8, 12 * 8, 8, 8);

	public InGameUI() {

	}

	public void renderPauseScreen(SpriteBatch sb) {
		int w = 256;
		int h = 256;

		int xo = 240;
		int yo = 80;

		int wa = 256 / 64;
		int ha = 256 / 64;

		for (int x = 1; x < wa; x++) {
			sb.draw(guiEdge3, xo + x * 64, yo + h, 64, 64);
			sb.draw(guiEdge4, xo + x * 64, yo, 64, 64);
		}

		for (int y = 1; y < ha; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}

		sb.draw(guiFill, xo + (1 * 64), yo + (1 * 64), 64, 64);
		sb.draw(guiFill, xo + (2 * 64), yo + (1 * 64), 64, 64);
		sb.draw(guiFill, xo + (3 * 64), yo + (1 * 64), 64, 64);
		sb.draw(guiFill, xo + (1 * 64), yo + (2 * 64), 64, 64);
		sb.draw(guiFill, xo + (2 * 64), yo + (2 * 64), 64, 64);
		sb.draw(guiFill, xo + (3 * 64), yo + (2 * 64), 64, 64);
		sb.draw(guiFill, xo + (1 * 64), yo + (3 * 64), 64, 64);
		sb.draw(guiFill, xo + (2 * 64), yo + (3 * 64), 64, 64);
		sb.draw(guiFill, xo + (3 * 64), yo + (3 * 64), 64, 64);

		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);

		Font.draw("GAME", sb, xo + 100, yo + h, 32);
		Font.draw("PAUSED", sb, xo + 65, yo + h - 40, 32);

		Font.draw("PRESS ESCAPE TO", sb, xo + 40, yo + h - 80, 16);
		Font.draw("RESUME THE GAME", sb, xo + 40, yo + h - 110, 16);

	}

	public void renderMessageBox(SpriteBatch sb, GameState game) {
		int w = 320;
		int h = 80;

		int xo = Game.WIDTH - 370;
		int yo = 10;

		int wa = w / 64;
		int ha = h / 64;

		for (int x = 1; x < 10; x++) {
			sb.draw(guiEdge3, xo + x * 32, yo + h, 32, 32);
			sb.draw(guiEdge4, xo + x * 32, yo, 32, 32);
		}

		for (int y = 1; y < 3; y++) {
			sb.draw(guiEdge1, xo, yo + y * 32, 32, 32);
			sb.draw(guiEdge2, xo + w, yo + y * 32, 32, 32);
		}

		for (int y = 1; y < 3; y++) {
			for (int x = 1; x < 10; x++) {
				sb.draw(guiFill, xo + (x * 32), yo + (y * 32), 32, 32);
			}
		}

		sb.draw(guiCorner1, xo, yo + h, 32, 32);
		sb.draw(guiCorner2, xo + w, yo + h, 32, 32);
		sb.draw(guiCorner3, xo, yo, 32, 32);
		sb.draw(guiCorner4, xo + w, yo, 32, 32);

		// Font.draw("GAME", sb, xo + 100, yo + h, 32);
		// Font.draw("PAUSED", sb, xo + 65, yo + h - 40, 32);

		// Font.draw("PRESS ESCAPE TO", sb, xo + 40, yo + h - 80, 16);
		// Font.draw("RESUME THE GAME", sb, xo + 40, yo + h - 110, 16);

	}

	public void renderOverlay(SpriteBatch sb, GameState game) {
		renderHealthBar(sb, game);
		renderTimeBar(sb, game);
		renderMessageBox(sb, game);
		Font.draw("" + game.player.money, sb, 500, Game.HEIGHT - 53, 24);
		if (game.player.money < 100)
			sb.draw(coin, 550, Game.HEIGHT - 60, 32, 32);
		else
			sb.draw(coin, 570, Game.HEIGHT - 60, 32, 32);
	}

	private TextureRegion barEdge1 = new TextureRegion(Tile.tileSheet, 9 * 8, 12 * 8, 8, 8);
	private TextureRegion barEdge2 = new TextureRegion(Tile.tileSheet, 10 * 8, 12 * 8, 8, 8);
	private TextureRegion barEdge3 = new TextureRegion(Tile.tileSheet, 11 * 8, 12 * 8, 8, 8);
	private TextureRegion barFill = new TextureRegion(Tile.tileSheet, 12 * 8, 12 * 8, 2, 8);

	public void renderHealthBar(SpriteBatch sb, GameState game) {
		int w = 200;
		int xo = 20, yo = Game.HEIGHT - 60;
		int health = game.getCurrentLevel().getPlayer().health;
		int maxHealth = 200;
		int blocks = w - 64;

		Font.draw("HEALTH:", sb, 20, 458, 16);

		sb.draw(barEdge1, xo, yo, 32, 32);

		sb.draw(barEdge2, xo + w - 32 + 8, yo, 32, 32);

		for (int i = 0; i < (blocks / 32) + 1; i++) {
			sb.draw(barEdge3, xo + 32 + i * 32, yo, 32, 32);
		}

		for (int i = 0; i < health / 5; i++) {
			sb.draw(barFill, xo + 4 + (i * 5), yo, 5, 32);
		}
	}

	private TextureRegion timeFill = new TextureRegion(Tile.tileSheet, 13 * 8, 12 * 8, 2, 8);

	public void renderTimeBar(SpriteBatch sb, GameState game) {
		int w = 200;
		int xo = 260, yo = Game.HEIGHT - 60;
		float time = 10f - game.swapTimer;
		int blocks = w - 64;
		Font.draw("TIME LEFT:", sb, 260, 458, 16);

		sb.draw(barEdge1, xo, yo, 32, 32);

		sb.draw(barEdge2, xo + w - 32 + 8, yo, 32, 32);

		for (int i = 0; i < (blocks / 32) + 1; i++) {
			sb.draw(barEdge3, xo + 32 + i * 32, yo, 32, 32);
		}

		for (int i = 0; i < time * 20; i++) {
			sb.draw(timeFill, xo + 4 + (i * 1), yo, 1, 32);
		}
	}

	public void renderDeathScreen(SpriteBatch sb) {
		int w = 256;
		int h = 256;

		int xo = 240;
		int yo = 80;

		int wa = 256 / 64;
		int ha = 256 / 64;

		for (int x = 1; x < wa; x++) {
			sb.draw(guiEdge3, xo + x * 64, yo + h, 64, 64);
			sb.draw(guiEdge4, xo + x * 64, yo, 64, 64);
		}

		for (int y = 1; y < ha; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}

		for (int y = 1; y < 4; y++) {
			for (int x = 1; x < 4; x++) {
				sb.draw(guiFill, xo + (x * 64), yo + (y * 64), 64, 64);
			}
		}

		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);

		Font.draw("YOU", sb, xo + 100, yo + h, 32);
		Font.draw("DIED", sb, xo + 90, yo + h - 40, 32);

		Font.draw("PRESS ESCAPE TO", sb, xo + 40, yo + h - 80, 16);
		Font.draw("START AGAIN", sb, xo + 75, yo + h - 110, 16);
	}

	private TextureRegion coin = new TextureRegion(Tile.tileSheet, 4 * 8, 1 * 8, 8, 8);
	private TextureRegion buy = new TextureRegion(Tile.tileSheet, 4 * 8, 2 * 8, 4 * 8, 2 * 8);

	public void renderShop(SpriteBatch sb, GameState gameState) {
		int w = 512 + 200;
		int h = 256 + 128;

		int xo = 10;
		int yo = 20;

		int wa = w / 64;
		int ha = h / 64;

		for (int y = 1; y < ha; y++) {
			for (int x = 1; x < wa + 1; x++) {
				sb.draw(guiFill, xo + (x * 64), yo + (y * 64), 64, 64);
			}
		}

		for (int x = 1; x < wa; x++) {
			sb.draw(guiEdge3, xo + x * 64, yo + h, 64, 64);
			sb.draw(guiEdge4, xo + x * 64, yo, 64, 64);
		}

		sb.draw(guiEdge3, xo + wa * 64, yo + h, 32, 64);
		sb.draw(guiEdge4, xo + wa * 64, yo, 32, 64);

		for (int y = 1; y < ha; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}
		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);

		Font.draw("SHOP", sb, xo + 280, yo + h, 32);

		Font.draw("WEAPONS", sb, xo + 40, yo + h - 45, 24);
		Font.draw("DEFENCE", sb, xo + 300, yo + h - 45, 24);
		Font.draw("SPECIAL", sb, xo + 560, yo + h - 45, 24);

		Font.draw("RUSTY SWORD", sb, xo + 30, yo + h - 85, 16);
		Font.draw("STEEL SWORD", sb, xo + 30, yo + h - 115, 16);

		Font.draw("LEATHER ARMOUR", sb, xo + 270, yo + h - 85, 16);

		Font.draw("REGENERATE  ", sb, xo + 560, yo + h - 85, 16);
		Font.draw("ALL HEALTH", sb, xo + 560, yo + h - 115, 16);
		Font.draw("100", sb, xo + 560, yo + h - 145, 16);
		sb.draw(coin, xo + 608, yo + h - 147, 16, 16);
		sb.draw(buy, xo + 625, yo + h - 153, 64, 32);

		Font.draw("KILL ALL", sb, xo + 560, yo + h - 195, 16);
		Font.draw("ZOMBIES", sb, xo + 560, yo + h - 225, 16);
		Font.draw("300", sb, xo + 560, yo + h - 255, 16);
		sb.draw(coin, xo + 608, yo + h - 257, 16, 16);
		sb.draw(buy, xo + 625, yo + h - 263, 64, 32);

		sb.draw(coin, xo + 680, yo + h - 0, 32, 32);

	}

}
