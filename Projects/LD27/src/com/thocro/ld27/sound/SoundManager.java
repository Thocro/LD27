package com.thocro.ld27.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

	public static Sound hit, hit2;
	public static Sound zombie1, zombie2, zombie3;
	public static Music bg1;

	public static void load() {
		hit = Gdx.audio.newSound(Gdx.files.internal("sound/Hit_Hurt2.mp3"));
		hit2 = Gdx.audio.newSound(Gdx.files.internal("sound/Hit_Hurt3.mp3"));

		zombie1 = Gdx.audio.newSound(Gdx.files.internal("sound/zombie1.mp3"));
		zombie2 = Gdx.audio.newSound(Gdx.files.internal("sound/zombie2.mp3"));
		zombie3 = Gdx.audio.newSound(Gdx.files.internal("sound/zombie3.mp3"));

		bg1 = Gdx.audio.newMusic(Gdx.files.internal("sound/bg2.mp3"));
		bg1.setVolume(0.2f);
		bg1.play();
		bg1.setLooping(true);

	}

}
