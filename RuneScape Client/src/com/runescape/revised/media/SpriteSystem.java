package com.runescape.revised.media;

public class SpriteSystem {

	private static SpriteSystem spriteSystem;

	public static void setSpriteSystem(SpriteSystem spriteSystem) {
		SpriteSystem.spriteSystem = spriteSystem;
	}

	public static SpriteSystem getSpriteSystem() {
		return SpriteSystem.spriteSystem;
	}
}