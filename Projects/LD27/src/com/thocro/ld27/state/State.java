package com.thocro.ld27.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface State {

	public void enter();

	public void exit();

	public void render(SpriteBatch sb);

	public void update(float delta);

	public String getName();

}
