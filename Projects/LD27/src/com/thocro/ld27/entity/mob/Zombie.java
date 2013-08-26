package com.thocro.ld27.entity.mob;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.level.tile.Tile;
import com.thocro.ld27.sound.SoundManager;

public class Zombie extends Mob {
	public float speed = 70;
	// private float animCount;
	// private int currentFrame = 1;

	private int txtId;

	private float attackCounterCount;
	private boolean attackCounter;

	private static TextureRegion tx1 = new TextureRegion(Tile.tileSheet, 64, 4 * 8, 16, 16);
	private static TextureRegion tx2 = new TextureRegion(Tile.tileSheet, 64 + 16, 4 * 8, 16, 16);

	private static TextureRegion tx11 = new TextureRegion(Tile.tileSheet, 64, 6 * 8, 16, 16);
	private static TextureRegion tx12 = new TextureRegion(Tile.tileSheet, 64 + 16, 6 * 8, 16, 16);

	private static TextureRegion tx21 = new TextureRegion(Tile.tileSheet, 64, 8 * 8, 16, 16);
	private static TextureRegion tx22 = new TextureRegion(Tile.tileSheet, 64 + 16, 8 * 8, 16, 16);

	private static TextureRegion tx31 = new TextureRegion(Tile.tileSheet, 64, 10 * 8, 16, 16);
	private static TextureRegion tx32 = new TextureRegion(Tile.tileSheet, 64 + 16, 10 * 8, 16, 16);

	public Zombie(int x, int y, Level l) {
		super(tx1, x, y, 64, 64, l);
		txtId = rand.nextInt(2) + 1;
	}

	Random rand = new Random();

	int xa = 0, ya = 0;

	public void update(float delta, Level l) {
		if (attackCounter) {
			attackCounterCount += delta;
			if (attackCounterCount >= 0.2f) {
				attackCounter = false;
				attackCounterCount -= 0.2f;
			}
		}

		testAttacks(delta, l);
		if (txtId == 1) {
			if (dir == 1)
				text = tx1;
			else if (dir == 0)
				text = tx11;
			else if (dir == 2)
				text = tx21;
			else if (dir == 3)
				text = tx31;
		} else if (txtId == 2) {
			if (dir == 1)
				text = tx2;
			else if (dir == 0)
				text = tx12;
			else if (dir == 2)
				text = tx22;
			else if (dir == 3)
				text = tx32;
		}
		moving = false;

		if (rand.nextInt(100) == 1) {
			xa = 1;
		} else if (rand.nextInt(100) == 1) {
			xa = -1;
		} else if (rand.nextInt(100) == 1) {
			ya = 1;
		} else if (rand.nextInt(100) == 1) {
			ya = -1;
		}

		if (xa != 0 || ya != 0) {
			xa = (int) (xa * speed * delta);
			ya = (int) (ya * speed * delta);
			move(xa, ya);
		}

	}

	private void testAttacks(float delta, Level l) {
		if (!attackCounter) {
			Player p = l.getPlayer();
			if (p != null) {
				int px = p.x;
				int py = p.y;
				if (!p.dead) {
					if (Math.abs(px - x) <= attackRadius && Math.abs(py - y) <= attackRadius) {
						System.out.println("Hit player");
						p.health -= (attack - p.defence);
						attackCounter = true;

						SoundManager.hit.play();

					}
				}
			}
		}
	}

}
