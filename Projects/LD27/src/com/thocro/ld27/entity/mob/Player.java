package com.thocro.ld27.entity.mob;

import java.awt.List;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.entity.Entity;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;

public class Player extends Mob {

	public float speed = 120;
	private float animCount;
	private int currentFrame = 1;
	public int maxHealth = 200;
	
	public int money = 10;

	private static TextureRegion tx1 = new TextureRegion(Tile.tileSheet, 0, 4 * 8, 16, 16);
	private static TextureRegion tx2 = new TextureRegion(Tile.tileSheet, 16, 4 * 8, 16, 16);
	private static TextureRegion tx3 = new TextureRegion(Tile.tileSheet, 32, 4 * 8, 16, 16);
	private static TextureRegion tx4 = new TextureRegion(Tile.tileSheet, 48, 4 * 8, 16, 16);

	private static TextureRegion tx11 = new TextureRegion(Tile.tileSheet, 0, 6 * 8, 16, 16);
	private static TextureRegion tx12 = new TextureRegion(Tile.tileSheet, 16, 6 * 8, 16, 16);
	private static TextureRegion tx13 = new TextureRegion(Tile.tileSheet, 32, 6 * 8, 16, 16);
	private static TextureRegion tx14 = new TextureRegion(Tile.tileSheet, 48, 6 * 8, 16, 16);

	private static TextureRegion tx21 = new TextureRegion(Tile.tileSheet, 0, 8 * 8, 16, 16);
	private static TextureRegion tx22 = new TextureRegion(Tile.tileSheet, 16, 8 * 8, 16, 16);
	private static TextureRegion tx23 = new TextureRegion(Tile.tileSheet, 32, 8 * 8, 16, 16);
	private static TextureRegion tx24 = new TextureRegion(Tile.tileSheet, 48, 8 * 8, 16, 16);

	private static TextureRegion tx31 = new TextureRegion(Tile.tileSheet, 0, 10 * 8, 16, 16);
	private static TextureRegion tx32 = new TextureRegion(Tile.tileSheet, 16, 10 * 8, 16, 16);
	private static TextureRegion tx33 = new TextureRegion(Tile.tileSheet, 32, 10 * 8, 16, 16);
	private static TextureRegion tx34 = new TextureRegion(Tile.tileSheet, 48, 10 * 8, 16, 16);

	public Player(int x, int y, Level l) {
		super(tx1, x, y, 64, 64, l);
		attackRadius = 60;
		attack = 40;
	}

	public void update(float delta, Level l) {
		pollInput(delta);
		if (moving) {
			animCount += delta;
			if (animCount > 0.17f) {
				animCount -= 0.17f;
				if (dir == 1) {
					if (currentFrame == 1) {
						text = tx2;
						currentFrame = 2;
					} else if (currentFrame == 2) {
						text = tx3;
						currentFrame = 3;
					} else if (currentFrame == 3) {
						text = tx4;
						currentFrame = 4;
					} else if (currentFrame == 4) {
						text = tx1;
						currentFrame = 1;
					} else {
						currentFrame = 1;
					}
				} else if (dir == 0) {
					if (currentFrame == 11) {
						text = tx12;
						currentFrame = 12;
					} else if (currentFrame == 12) {
						text = tx13;
						currentFrame = 13;
					} else if (currentFrame == 13) {
						text = tx14;
						currentFrame = 14;
					} else if (currentFrame == 14) {
						text = tx11;
						currentFrame = 11;
					} else {
						currentFrame = 11;
					}
				} else if (dir == 2) {
					if (currentFrame == 21) {
						text = tx22;
						currentFrame = 22;
					} else if (currentFrame == 22) {
						text = tx23;
						currentFrame = 23;
					} else if (currentFrame == 23) {
						text = tx24;
						currentFrame = 24;
					} else if (currentFrame == 24) {
						text = tx21;
						currentFrame = 21;
					} else {
						currentFrame = 21;
					}
				} else if (dir == 3) {
					if (currentFrame == 31) {
						text = tx32;
						currentFrame = 32;
					} else if (currentFrame == 32) {
						text = tx33;
						currentFrame = 33;
					} else if (currentFrame == 33) {
						text = tx34;
						currentFrame = 34;
					} else if (currentFrame == 34) {
						text = tx31;
						currentFrame = 31;
					} else {
						currentFrame = 31;
					}
				}
			}
		}
		moving = false;
	}

	public void pollInput(float delta) {
		Input i = Gdx.input;

		int xa = 0, ya = 0;
		if (i.isKeyPressed(Keys.W)) {
			ya = 1;
		}
		if (i.isKeyPressed(Keys.S)) {
			ya = -1;
		}
		if (i.isKeyPressed(Keys.A)) {
			xa = -1;
		}
		if (i.isKeyPressed(Keys.D)) {
			xa = 1;
		}
		if (xa != 0 || ya != 0) {
			xa = (int) (xa * speed * delta);
			ya = (int) (ya * speed * delta);
			move(xa, ya);
		}
	}

	public void attack(Level l) {
		ArrayList<Entity> mobs = l.entities;
		for (Entity e : mobs) {
			if (e instanceof Mob)
				if (!((Mob) e).dead) {
					if (Math.abs(e.x - x) <= attackRadius && Math.abs(e.y - y) <= attackRadius) {
						((Mob) e).health -= (attack - ((Mob) e).defence);
						System.out.println("Attacked mob");
						
					}
				}
		}
	}

}
