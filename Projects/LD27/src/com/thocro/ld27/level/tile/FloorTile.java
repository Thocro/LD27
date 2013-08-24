package com.thocro.ld27.level.tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FloorTile extends Tile {

	public FloorTile() {
		super(1, new TextureRegion(Tile.tileSheet, 0, 0, 8, 8));

		if (Tile.rand.nextInt(20) == 1) {
			texture = new TextureRegion(Tile.tileSheet, 8, 0, 8, 8);
		}
		if (Tile.rand.nextInt(20) == 1) {
			texture = new TextureRegion(Tile.tileSheet, 16, 0, 8, 8);
		}

	}

}
