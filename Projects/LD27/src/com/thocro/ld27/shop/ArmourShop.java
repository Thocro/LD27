package com.thocro.ld27.shop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.entity.ShopEntity;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;

public class ArmourShop extends ShopEntity{

	public ArmourShop(int x, int y, Level l) {
		super(x, y, l);
		w = 64;
		h = 40;
		this.y += 25;
		text = new TextureRegion(Tile.tileSheet, 9 * 8, 2 * 8, 8, 8);
	}
	
	public void render(SpriteBatch sb, int xo, int yo) {
		sb.draw(text, xo + x + 8, yo + y, 32, 32);
		Font.draw("DEFENCE", sb, xo + x, yo + y - 10, 8);
		Font.draw("SHOP", sb, xo + x + 10, yo + y - 20, 8);
	}


}
