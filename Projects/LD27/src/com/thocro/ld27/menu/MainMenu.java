package com.thocro.ld27.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.thocro.ld27.Game;
import com.thocro.ld27.game.GameState;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.tile.FloorTile;
import com.thocro.ld27.level.tile.Tile;
import com.thocro.ld27.state.State;

public class MainMenu implements State, InputProcessor {

	private TextureRegion guiCorner1 = new TextureRegion(Tile.tileSheet, 0, 12 * 8, 8, 8);
	private TextureRegion guiCorner2 = new TextureRegion(Tile.tileSheet, 1 * 8, 12 * 8, 8, 8);
	private TextureRegion guiCorner3 = new TextureRegion(Tile.tileSheet, 2 * 8, 12 * 8, 8, 8);
	private TextureRegion guiCorner4 = new TextureRegion(Tile.tileSheet, 3 * 8, 12 * 8, 8, 8);

	private TextureRegion guiEdge1 = new TextureRegion(Tile.tileSheet, 4 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge2 = new TextureRegion(Tile.tileSheet, 5 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge3 = new TextureRegion(Tile.tileSheet, 6 * 8, 12 * 8, 8, 8);
	private TextureRegion guiEdge4 = new TextureRegion(Tile.tileSheet, 7 * 8, 12 * 8, 8, 8);

	private TextureRegion guiFill = new TextureRegion(Tile.tileSheet, 8 * 8, 12 * 8, 8, 8);

	private TextureRegion button = new TextureRegion(Tile.tileSheet, 0 * 8, 3 * 8, 16, 8);

	private Tile[] tiles;
	private int scrollW = 80, scrollH = 15;
	private int scrollX, scrollY;

	private float scrollCount;

	public void enter() {
		Gdx.input.setInputProcessor(this);
		Font.load();
		tiles = new Tile[scrollW * scrollH];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new FloorTile();
		}
	}

	public void exit() {

	}

	int xo = 180;
	int yo = 15;

	private Rectangle play = new Rectangle(xo + 130, yo + 150, 128 + 64, 64 + 32);
	private Rectangle about = new Rectangle(xo + 130, yo + 35, 128 + 64, 64 + 32);
	
	public Texture logo = new Texture("textures/title.png");

	public void render(SpriteBatch sb) {
		renderBG(sb);
		sb.draw(logo, xo + 100, yo + 275, 256, 128);
		
		sb.draw(button, xo + 130, yo + 150, 128 + 64, 64 + 32);
		Font.draw("PLAY", sb, xo + 147, yo + 180, 32 + 8);

		sb.draw(button, xo + 130, yo + 35, 128 + 64, 64 + 32);
		Font.draw("ABOUT", sb, xo + 145, yo + 68, 32);

	}

	private void renderBG(SpriteBatch sb) {
		for (int y = 0; y < scrollH; y++) {
			for (int x = 0; x < scrollW; x++) {
				tiles[x + y * scrollW].render(sb, (x * 32) - scrollX, y * 32, 32, 32);

			}
		}

		int w = 256 + 128;
		int h = 256 + 128;

		int wa = w / 64;
		int ha = h / 64;

		for (int y = 0; y < ha; y++) {
			for (int x = 0; x < wa; x++) {
				sb.draw(guiFill, xo + (x * 64) + 64, yo + (y * 64) + 32, 64, 64);
			}
		}

		for (int x = 1; x < wa; x++) {
			sb.draw(guiEdge3, xo + x * 64, yo + h, 64, 64);
			sb.draw(guiEdge4, xo + x * 64, yo, 64, 64);
		}

		for (int y = 1; y < ha; y++) {
			sb.draw(guiEdge1, xo, yo + y * 64, 64, 64);
			sb.draw(guiEdge2, xo + w, yo + y * 64, 64, 64);
		}
		sb.draw(guiCorner1, xo, yo + h, 64, 64);
		sb.draw(guiCorner2, xo + w, yo + h, 64, 64);
		sb.draw(guiCorner3, xo, yo, 64, 64);
		sb.draw(guiCorner4, xo + w, yo, 64, 64);
	}

	int xa = 1;

	public void update(float delta) {
		if (scrollX > scrollW * 32 - 800) {
			xa = -1;
		} else if (scrollX < 0) {
			xa = 1;
		}
		scrollX += xa;
	}

	public String getName() {
		return "Main Menu";
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenY = 480 - screenY;

		if (play.contains(screenX, screenY)) {
			Game.changeState(new GameState());
		}
		if (about.contains(screenX, screenY)) {
			Game.changeState(new AboutScreen());
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
