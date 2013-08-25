package com.thocro.ld27.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
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
		int health = game.player.health;
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
	

	public Rectangle wRust = new Rectangle(120 + 35, 30 + 360 - 200, 128, 64);
	public Rectangle wIron = new Rectangle(120 + 210, 30 + 360 - 200, 128, 64);
	public Rectangle wGold = new Rectangle(120 + 390, 30 + 360 - 200, 128, 64);

	private TextureRegion wRustText = new TextureRegion(Tile.tileSheet, 11 * 8, 2 * 8, 8, 8);
	private TextureRegion wIronText = new TextureRegion(Tile.tileSheet, 12 * 8, 2 * 8, 8, 8);
	private TextureRegion wGoldText = new TextureRegion(Tile.tileSheet, 13 * 8, 2 * 8, 8, 8);

	
	public void renderWeaponShop(SpriteBatch sb, GameState gameState) {
		int w = 512;
		int h = 360;

		int xo = 120;
		int yo = 30;

		int wa = w / 64;
		int ha = h / 64;

		for (int y = 1; y < ha  + 1; y++) {
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

		for (int y = 1; y < ha + 1; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}
		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);

		Font.draw("WEAPON SHOP", sb, xo + 60, yo + h, 32);

		Font.draw("RUSTY", sb, xo + 50, yo + h - 55, 24);
		Font.draw("SWORD", sb, xo + 50, yo + h - 95, 24);
		Font.draw("100", sb, xo + 50, yo + h - 130, 24);
		sb.draw(coin, xo + 128, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 35, yo + h - 200, 128, 64);
		
		sb.draw(wRustText, xo + 35, yo + 30, 128, 128);

		Font.draw("IRON", sb, xo + 230, yo + h - 55, 24);
		Font.draw("SWORD", sb, xo + 220, yo + h - 95, 24);
		Font.draw("250", sb, xo + 230, yo + h - 130, 24);
		sb.draw(coin, xo + 308, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 210, yo + h - 200, 128, 64);
		sb.draw(wIronText, xo + 210, yo + 30, 128, 128);

		
		Font.draw("GOLD", sb, xo + 410, yo + h - 55, 24);
		Font.draw("SWORD", sb, xo + 400, yo + h - 95, 24);
		Font.draw("400", sb, xo + 410, yo + h - 130, 24);
		sb.draw(coin, xo + 488, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 390, yo + h - 200, 128, 64);
		sb.draw(wGoldText, xo + 390, yo + 30, 128, 128);


	}
	
	public Rectangle aRust = new Rectangle(120 + 35, 30 + 360 - 200, 128, 64);
	public Rectangle aIron = new Rectangle(120 + 210, 30 + 360 - 200, 128, 64);
	public Rectangle aGold = new Rectangle(120 + 390, 30 + 360 - 200, 128, 64);
	
	public TextureRegion aRustText = new TextureRegion(Tile.tileSheet, 11 * 8, 3 * 8, 8, 8);
	public TextureRegion aIronText = new TextureRegion(Tile.tileSheet, 12 * 8, 3 * 8, 8, 8);
	public TextureRegion aGoldText = new TextureRegion(Tile.tileSheet, 13 * 8, 3 * 8, 8, 8);

	
	public void renderArmourShop(SpriteBatch sb, GameState gameState) {
		int w = 512;
		int h = 360;

		int xo = 120;
		int yo = 30;

		int wa = w / 64;
		int ha = h / 64;

		for (int y = 1; y < ha  + 1; y++) {
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

		for (int y = 1; y < ha + 1; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}
		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);

		Font.draw("DEFENCE SHOP", sb, xo + 60, yo + h, 32);

		Font.draw("RUSTY", sb, xo + 50, yo + h - 55, 24);
		Font.draw("SHIELD", sb, xo + 50, yo + h - 95, 24);
		Font.draw("100", sb, xo + 50, yo + h - 130, 24);
		sb.draw(coin, xo + 128, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 35, yo + h - 200, 128, 64);
		
		sb.draw(aRustText, xo + 35, yo + 30, 128, 128);

		Font.draw("IRON", sb, xo + 230, yo + h - 55, 24);
		Font.draw("SHEILD", sb, xo + 220, yo + h - 95, 24);
		Font.draw("250", sb, xo + 230, yo + h - 130, 24);
		sb.draw(coin, xo + 308, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 210, yo + h - 200, 128, 64);
		sb.draw(aIronText, xo + 210, yo + 30, 128, 128);

		
		Font.draw("GOLD", sb, xo + 410, yo + h - 55, 24);
		Font.draw("SHEILD", sb, xo + 400, yo + h - 95, 24);
		Font.draw("400", sb, xo + 410, yo + h - 130, 24);
		sb.draw(coin, xo + 488, yo + h - 137, 32, 32);
		sb.draw(buy, xo + 390, yo + h - 200, 128, 64);
		sb.draw(aGoldText, xo + 390, yo + 30, 128, 128);


	}


}
