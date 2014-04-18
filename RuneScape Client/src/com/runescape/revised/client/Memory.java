package com.runescape.revised.client;

import com.runescape.Rasterizer;
import com.runescape.Region;
import com.runescape.revised.config.definitions.ObjectDef;
import com.runescape.revised.graphics.SceneGraphic;

public class Memory {

	public static void setLowMem()
	{
		SceneGraphic.lowMem = true;
		Rasterizer.lowMem = true;
		GameClient.lowMem = true;
		Region.lowMem = true;
		ObjectDef.lowMem = true;
	}

	public static void setHighMem()
	{
		SceneGraphic.lowMem = false;
		Rasterizer.lowMem = false;
		GameClient.lowMem = false;
		Region.lowMem = false;
		ObjectDef.lowMem = false;
	}
}