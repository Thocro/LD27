package com.thocro.ld27.level;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.entity.Entity;
import com.thocro.ld27.entity.mob.Mob;
import com.thocro.ld27.entity.mob.Player;
import com.thocro.ld27.level.tile.FloorTile;
import com.thocro.ld27.level.tile.Tile;

public class Level {

	public int width, height;
	public Tile[] tiles;

	public ArrayList<Entity> entities;

	public Player player;
	
	public boolean playerDead;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width * height];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new FloorTile();
		}
		entities = new ArrayList<Entity>();
	}

	public void render(SpriteBatch sb, int xo, int yo) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width].render(sb, xo + (x * 32), yo + (y * 32), 32, 32);
			}
		}
		if (player != null)
			player.render(sb, xo, yo);
		for (Entity e : entities) {
			if (!e.dead)
				e.render(sb, xo, yo);
		}
	}

	public void update(float delta) {

		if (player != null)
			player.update(delta, this);
		for (Entity e : entities) {
			e.update(delta, this);
			if (e instanceof Mob) {
				if (((Mob) e).health <= 0) {
					e.dead = true;
					entities.remove(e);
					if(e instanceof Player)
						playerDead = true;
					System.out.println("Mob died");
					return;
				}
			}
		}
		if (player != null) {
			if (player.health <= 0) {
				player.dead = true;
			}
		}

	}


	public void clearLevel() {
		entities.clear();
	}

	public Player getPlayer() {
		return player;
	}

	public void add(Player p) {
		player = p;
	}

	public void remove(Player p) {
		player = null;
	}

}
