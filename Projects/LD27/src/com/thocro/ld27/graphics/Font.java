package com.thocro.ld27.graphics;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.level.tile.Tile;

public class Font {

	private static String chars = "" + //
			"ABCDEFGHIJKLMNOP" + //
			"QRSTUVWXYZ      " + //
			"1234567890.,!:  ";//
	private static ArrayList<TextureRegion> font;

	public static void load() {
		font = new ArrayList<TextureRegion>();
		font.add(new TextureRegion(Tile.tileSheet, 0 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 1 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 2 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 3 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 4 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 5 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 6 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 7 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 8 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 9 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 10 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 11 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 12 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 13 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 14 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 15 * 8, 13 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 0 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 1 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 2 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 3 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 4 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 5 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 6 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 7 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 8 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 9 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 10 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 11 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 12 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 13 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 14 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 15 * 8, 14 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 0 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 1 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 2 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 3 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 4 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 5 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 6 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 7 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 8 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 9 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 10 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 11 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 12 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 13 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 14 * 8, 15 * 8, 8, 8));
		font.add(new TextureRegion(Tile.tileSheet, 15 * 8, 15 * 8, 8, 8));


	}

	public static void draw(String text, SpriteBatch sb, int x, int y, int size) {
		text.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int index = chars.indexOf(c);
			if (index >= 0)
				sb.draw(font.get(index), x + i * size, y, size, size);
		}
	}

}
