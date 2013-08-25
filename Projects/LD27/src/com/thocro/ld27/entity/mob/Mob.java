package com.thocro.ld27.entity.mob;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.entity.Entity;
import com.thocro.ld27.level.Level;

public class Mob extends Entity {

	public int dir;
	public boolean moving;
	
	
	public int health = 200;
	public int attackRadius = 40, attack = 25, defence = 10;

	public Mob(TextureRegion text, int x, int y, int w, int h, Level l) {
		super(text, x, y, w, h, l);
	}

	public void move(int xa, int ya) {
		x += xa;
		y += ya;

		if (x < -15)
			x = -15;
		if (y < 0)
			y = 0;
		if (x > (level.width * 32) - w + 15) 
			x = (level.width * 32) - w + 15;
		if (y > (level.height * 32) - h + 25)
			y = (level.height * 32) - h + 25;

		if (xa > 0)
			dir = 2;
		if (xa < 0)
			dir = 3;

		if (ya > 0)
			dir = 0;
		if (ya < 0)
			dir = 1;

		moving = true;
	}

}
