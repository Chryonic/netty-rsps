package com.runescape.revised.texture;

import com.runescape.revised.System;

public class TextureSystem extends System {

	private static TextureSystem textureSystem;

	public static void setTextureSystem(TextureSystem textureSystem) {
		TextureSystem.textureSystem = textureSystem;
	}

	public static TextureSystem getTextureSystem() {
		return TextureSystem.textureSystem;
	}
}