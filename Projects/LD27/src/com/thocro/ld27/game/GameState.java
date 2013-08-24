package com.thocro.ld27.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.Game;
import com.thocro.ld27.entity.mob.Player;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.state.State;

public class GameState implements State, InputProcessor {

	public Level level1, level2;
	public Player player;

	public void enter() {
		level1 = new Level(11, 10);
		level2 = new Level(11, 10);
		player = new Player(10, 10, level1);
		level1.add(player);
		Font.load();
	}

	public void exit() {

	}

	public void render(SpriteBatch sb) {
		level1.render(sb, 10, 10);
		level2.render(sb, 436, 10);

		Font.draw("FPS: " + Gdx.graphics.getFramesPerSecond(), sb, 0, Game.HEIGHT - 32, 16);
	}

	public void update(float delta) {
		pollInput(delta);
		level1.update(delta);
		level2.update(delta);

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
			xa = (int) (xa * player.speed * delta);
			ya = (int) (ya * player.speed * delta);
			player.move(xa, ya);
		}
	}

	public String getName() {
		return "In Game";
	}

	public boolean keyDown(int keycode) {
		return false;
	}

	public boolean keyUp(int keycode) {
		return false;
	}

	public boolean keyTyped(char character) {
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	public boolean scrolled(int amount) {
		return false;
	}

}
