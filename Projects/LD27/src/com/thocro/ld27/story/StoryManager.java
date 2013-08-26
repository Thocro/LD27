package com.thocro.ld27.story;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thocro.ld27.game.GameState;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.tile.Tile;

public class StoryManager {

	public int frame = 1;

	private float counter;
	private boolean count;

	public void update(float delta, GameState game) {
		if (frame == 1 && !game.internallyPaused) {
			game.internallyPaused = true;
		}
		if (count) {
			counter += delta;
		}
		if (frame == 5) {
			if (counter > 0.5f) {
				count = false;
				game.internallyPaused = false;
				counter = 0f;
				frame++;
			}
			count = true;
		}

		if (frame == 6 && game.player.money > 100) {
			frame++;
		}
		if (frame == 1) {
			if (!count)
				count = true;
			if (counter > 0.5f) {
				if (arrowUp == 10) {
					arrowUp = 0;
				} else {
					arrowUp = 10;
				}
				counter -= 0.5f;
			}
		}

	}

	private TextureRegion arrow = new TextureRegion(Tile.tileSheet, 3 * 8, 1 * 8, 8, 8);

	int arrowUp;

	public void render(SpriteBatch sb, int xo, int yo) {
		if (frame == 1) {
			Font.draw("WELCOME TEST SUBJECT", sb, xo - 0, yo + 55, 16);
			Font.draw("13B TO OUR NEW TEST!", sb, xo - 0, yo + 30, 16);
			Font.draw("PRESS SPACE TO CONT", sb, xo - 0, yo + 4, 16);
			sb.draw(arrow, xo - 100, yo + 100 + arrowUp, 128, 128);

		} else if (frame == 2) {
			Font.draw("IN HERE THERE ARE 2", sb, xo - 0, yo + 55, 16);
			Font.draw("ROOMS, ONE IS SAFE!", sb, xo - 0, yo + 30, 16);
			Font.draw("PRESS SPACE TO CONT", sb, xo - 0, yo + 4, 16);
		} else if (frame == 3) {
			Font.draw("AND THE OTHER IS", sb, xo - 0, yo + 55, 16);
			Font.draw("FULL OF MONSTERS!", sb, xo - 0, yo + 30, 16);
			Font.draw("PRESS SPACE TO CONT", sb, xo - 0, yo + 4, 16);
		} else if (frame == 4) {
			Font.draw("EVERY 10 SECONDS", sb, xo - 0, yo + 55, 16);
			Font.draw("YOU WILL SWAP ROOMS!", sb, xo - 0, yo + 30, 16);
			Font.draw("PRESS SPACE TO CONT", sb, xo - 0, yo + 4, 16);
		} else if (frame == 5 || frame == 6) {
			Font.draw("USE WASD TO MOVE", sb, xo - 0, yo + 55, 16);
			Font.draw("AND SPACE TO ATTACK!", sb, xo - 0, yo + 30, 16);
			Font.draw("GOOD LUCK!", sb, xo + 70, yo + 4, 16);
		} else if (frame == 7) {
			Font.draw("IN THE SAFE ZONE", sb, xo - 0, yo + 55, 16);
			Font.draw("YOU CAN SPEND MONEY ", sb, xo - 0, yo + 30, 16);
			Font.draw("IN THE SHOPS.", sb, xo + 70, yo + 4, 16);
		}

	}

	public void keyPressed(int keycode) {
		if (keycode == Keys.SPACE) {
			if (frame < 5) {
				frame++;
				count = false;
			}
		}
	}

}
