package com.thocro.ld27.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.level.Level;

public class Entity {
	public int x, y;
	public int w, h;

	public TextureRegion text;

	protected Level level;

	public Entity(TextureRegion text, int x, int y, int w, int h, Level level) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.level = level;
	}

	public void render(SpriteBatch sb, int xo, int yo) {
		sb.draw(text, x + xo, y + yo, w, h);
	}

	public void update(float delta) {

	}
}
