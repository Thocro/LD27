package com.thocro.ld27.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.level.tile.FloorTile;
import com.thocro.ld27.level.tile.Tile;

public class Level {

	public int width, height;
	public Tile[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width * height];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new FloorTile();
		}
	}

	public void render(SpriteBatch sb, int xo, int yo) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width].render(sb, xo + (x * 32), yo + (y * 32), 32, 32);
			}
		}
	}

	public void update(float delta) {

	}

}
