package com.thocro.ld27;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thocro.ld27.game.GameState;
import com.thocro.ld27.state.State;

public class Game implements ApplicationListener {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public static final int WIDTH = 800, HEIGHT = 480;
	public static final String TITLE = "Untitled Game";
	public static final boolean FULLSCREEN = false;

	public static State currentState;

	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		changeState(new GameState());
		init();
	}

	public void init() {

	}

	public void resize(int width, int height) {

	}

	public void render() {
		update();
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		currentState.render(batch);
		batch.end();
	}

	public void update() {
		float delta = Gdx.graphics.getDeltaTime();
		currentState.update(delta);
	}

	public void pause() {

	}

	public void resume() {

	}

	public void dispose() {
		currentState.exit();
	}

	public static void changeState(State s) {
		if (currentState != null)
			currentState.exit();
		currentState = s;
		currentState.enter();
		System.out.println("Entered state: " + currentState.getName());
	}

}
