package com.thocro.ld27.level.tile;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {

	public static Texture tileSheet = new Texture("textures/tiles.png");
	public static Random rand = new Random();

	public int id;
	public TextureRegion texture;

	public Tile(int id, TextureRegion texture) {
		this.id = id;
		this.texture = texture;
	}

	public void render(SpriteBatch sb, int x, int y, int w, int h) {
		sb.draw(texture, x, y, w, h);
	}

}
