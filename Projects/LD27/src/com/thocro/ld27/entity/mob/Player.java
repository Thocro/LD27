package com.thocro.ld27.entity.mob;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.entity.Entity;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;

public class Player extends Mob {

	public float speed = 120;
	private float animCount;
	private int currentFrame = 1;
	public int maxHealth = 200;

	public int weapon, armour;

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

	public TextureRegion wRustText = new TextureRegion(Tile.tileSheet, 11 * 8, 2 * 8, 8, 8);
	public TextureRegion wIronText = new TextureRegion(Tile.tileSheet, 12 * 8, 2 * 8, 8, 8);
	public TextureRegion wGoldText = new TextureRegion(Tile.tileSheet, 13 * 8, 2 * 8, 8, 8);
	public TextureRegion aRustText = new TextureRegion(Tile.tileSheet, 11 * 8, 3 * 8, 8, 8);
	public TextureRegion aIronText = new TextureRegion(Tile.tileSheet, 12 * 8, 3 * 8, 8, 8);
	public TextureRegion aGoldText = new TextureRegion(Tile.tileSheet, 13 * 8, 3 * 8, 8, 8);

	public Sprite wRust = new Sprite(wRustText);
	public Sprite wIron = new Sprite(wIronText);
	public Sprite wGold = new Sprite(wGoldText);
	public Sprite wRust2 = new Sprite(wRustText);
	public Sprite wIron2 = new Sprite(wIronText);
	public Sprite wGold2 = new Sprite(wGoldText);

	public Player(int x, int y, Level l) {
		super(tx1, x, y, 64, 64, l);
		attackRadius = 60;
		attack = 35;

		wRust.rotate(360f - 45f);
		wIron.rotate(360f - 45f);
		wGold.rotate(360f - 45f);

		wRust2.rotate(45f);
		wIron2.rotate(45f);
		wGold2.rotate(45f);

	}

	public void render(SpriteBatch sb, int xo, int yo) {
		if (dir == 1) {
			sb.draw(text, xo + x, yo + y, 64, 64);
			if (weapon == 1) {
				sb.draw(wRustText, xo + x + 5, yo + y + 12, 24, 32);
			} else if (weapon == 2) {
				sb.draw(wIronText, xo + x + 5, yo + y + 12, 24, 32);
			} else if (weapon == 3) {
				sb.draw(wGoldText, xo + x + 5, yo + y + 12, 24, 32);
			}
			if (armour == 1) {
				sb.draw(aRustText, xo + x + 25, yo + y + 10, 32, 32);
			} else if (armour == 2) {
				sb.draw(aIronText, xo + x + 25, yo + y + 10, 32, 32);
			} else if (armour == 3) {
				sb.draw(aGoldText, xo + x + 25, yo + y + 10, 32, 32);
			}

		} else if (dir == 0) {
			if (weapon == 1) {
				sb.draw(wRustText, xo + x + 5, yo + y + 12, 24, 32);
			} else if (weapon == 2) {
				sb.draw(wIronText, xo + x + 5, yo + y + 12, 24, 32);
			} else if (weapon == 3) {
				sb.draw(wGoldText, xo + x + 5, yo + y + 12, 24, 32);
			}
			if (armour == 1) {
				sb.draw(aRustText, xo + x + 25, yo + y + 10, 32, 32);
			} else if (armour == 2) {
				sb.draw(aIronText, xo + x + 25, yo + y + 10, 32, 32);
			} else if (armour == 3) {
				sb.draw(aGoldText, xo + x + 25, yo + y + 10, 32, 32);
			}
			sb.draw(text, xo + x, yo + y, 64, 64);
		} else if (dir == 2) {
			sb.draw(text, xo + x, yo + y, 64, 64);
			if (weapon == 1) {
				wRust.setBounds(xo + x + 28, yo + y + 18, 24, 32);
				wRust.draw(sb);
			} else if (weapon == 2) {
				wIron.setBounds(xo + x + 28, yo + y + 18, 24, 32);
				wIron.draw(sb);
			} else if (weapon == 3) {
				wGold.setBounds(xo + x + 28, yo + y + 18, 24, 32);
				wGold.draw(sb);
			}
		} else if (dir == 3) {
			sb.draw(text, xo + x, yo + y, 64, 64);
			if (weapon == 1) {
				wRust2.setBounds(xo + x + 25, yo + y + 8, 24, 32);
				wRust2.draw(sb);
			} else if (weapon == 2) {
				wIron2.setBounds(xo + x + 25, yo + y + 8, 24, 32);
				wIron2.draw(sb);
			} else if (weapon == 3) {
				wGold2.setBounds(xo + x + 25, yo + y + 8, 24, 32);
				wGold2.draw(sb);
			}
		}

	}

	int prevDir;

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
		if (dir != prevDir) {
			if (dir == 0) {
				text = tx11;
				currentFrame = 11;
			} else if (dir == 1) {
				text = tx1;
				currentFrame = 1;
			} else if (dir == 2) {
				text = tx21;
				currentFrame = 21;
			} else if (dir == 3) {
				text = tx31;
				currentFrame = 31;
			}
		}

		moving = false;
		prevDir = dir;
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
