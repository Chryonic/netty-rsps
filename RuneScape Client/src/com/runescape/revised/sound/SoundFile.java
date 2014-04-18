package com.runescape.revised.sound;

import java.io.File;

public class SoundFile extends File {

	private static final long serialVersionUID = 1L;
	private String name;
	private SoundType soundType;
	
	public SoundFile(String name, SoundType soundType) {
		super(name);
		this.setName(name);
		this.setSoundType(soundType);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSoundType(SoundType soundType) {
		this.soundType = soundType;
	}

	public SoundType getSoundType() {
		return this.soundType;
	}
}