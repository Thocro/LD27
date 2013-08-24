package com.thocro.ld27.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.Game;
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

		Font.draw("PRESS ESCAPE TO", sb, xo + 40, yo + h- 80, 16);
		Font.draw("RESUME THE GAME", sb, xo + 40, yo + h- 110, 16);

	}

}
