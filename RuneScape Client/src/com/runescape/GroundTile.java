package com.runescape;

import com.runescape.revised.graphics.cache.GroundItemTile;
import com.runescape.revised.graphics.cache.Wall;
import com.runescape.revised.graphics.cache.FloorDecoration;
import com.runescape.revised.graphics.cache.InteractiveObject;
import com.runescape.revised.graphics.cache.PlainTile;
import com.runescape.revised.graphics.cache.ShapedTile;
import com.runescape.revised.graphics.cache.WallDecoration;
import com.runescape.revised.util.node.Node;

public class GroundTile extends Node {

	public int tileZ; // anInt1307
	public int tileX; // anInt1308
	public int tileY; // anInt1309
	public int anInt1310; // anInt1310
	public PlainTile aClass43_1311; // aClass43_1311
	public ShapedTile aClass40_1312; // aClass40_1312
	public Wall wall; // obj1
	public WallDecoration wallDecoration; // obj2
	public FloorDecoration floorDecoration; // obj3
	public GroundItemTile groundItemTile; // obj4
	public int actorCount; // anInt1317
	public InteractiveObject[] interactiveObjects; // obj5Array
	public int[] anIntArray1319;
	public int anInt1320;
	public int logicHeight; // anInt1321
	public boolean aBoolean1322;
	public boolean aBoolean1323;
	public boolean aBoolean1324;
	public int anInt1325;
	public int anInt1326;
	public int anInt1327;
	public int anInt1328;
	public GroundTile tileBelow; // aClass30_Sub3_1329

	public GroundTile(int plane, int x, int y) {
		interactiveObjects = new InteractiveObject[5];
		anIntArray1319 = new int[5];
		anInt1310 = tileZ = plane;
		tileX = x;
		tileY = y;
	}
}