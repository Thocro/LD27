package com.thocro.ld27.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.entity.mob.Player;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;

public class ShopEntity extends Entity {

	public boolean open;

	public ShopEntity(int x, int y, Level l) {
		super(new TextureRegion(Tile.tileSheet, 0, 8, 4 * 8, 2 * 8), x, y, 140, 64, l);
	}

	public void render(SpriteBatch sb, int xo, int yo) {
		sb.draw(text, xo + x, yo + y, 140, 64);
		Font.draw("SHOP", sb, xo + x + 5, yo + y + 15, 32);
	}

	public void update(float delta, Level l) {
		Player p = l.getPlayer();
		if (p != null) {
			if (!open) {
				System.out.println(Math.abs(x - p.x));

				if (Math.abs(x - p.x) <= w /2  && Math.abs(p.y - y) <= h) {
					open = true;
				}
			}

		}
	}

}
