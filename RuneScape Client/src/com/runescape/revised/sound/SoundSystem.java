package com.runescape.revised.sound;

import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundSystem {

	private SoundFile soundFile;
	
	public SoundSystem() {
		InputStream in;
		try {
			in = new FileInputStream(new SoundFile("", SoundType.WAVE));
			AudioStream audios = new AudioStream(in);
			AudioPlayer.player.start(audios);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setSoundFile(SoundFile soundFile) {
		this.soundFile = soundFile;
	}

	public SoundFile getSoundFile() {
		return soundFile;
	}
}