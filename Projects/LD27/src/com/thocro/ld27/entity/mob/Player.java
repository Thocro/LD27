package com.thocro.ld27.entity.mob;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;

public class Player extends Mob {

	public float speed = 200;

	public Player(int x, int y, Level l) {
		super(new TextureRegion(Tile.tileSheet, 0, 4 * 8, 16, 16), x, y, 64, 64, l);
	}

}
