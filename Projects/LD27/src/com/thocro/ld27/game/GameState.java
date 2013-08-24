package com.thocro.ld27.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.Game;
import com.thocro.ld27.graphics.Font;
import com.thocro.ld27.level.Level;
import com.thocro.ld27.state.State;

public class GameState implements State {

	public Level level1, level2;

	public void enter() {
		level1 = new Level(11, 10);
		level2 = new Level(11, 10);
		Font.load();
	}

	public void exit() {

	}

	public void render(SpriteBatch sb) {
		level1.render(sb, 10, 10);
		level2.render(sb, 436, 10);

		Font.draw("FONT WORKS! GAU412SFMC", sb, 0, Game.HEIGHT - 32, 32);
	}

	public void update(float delta) {
		
	}

	public String getName() {
		return "In Game";
	}

}
