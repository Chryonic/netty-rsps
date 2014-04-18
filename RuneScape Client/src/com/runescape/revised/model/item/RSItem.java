package com.runescape.revised.model.item;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
import com.runescape.Renderable;
import com.runescape.revised.config.definitions.ItemDef;
import com.runescape.revised.model.RSModel;

final class RSItem extends Renderable {

	public final RSModel getRotatedModel() {
		ItemDef itemDef = ItemDef.forID(ID);
		return itemDef.method201(anInt1559);
	}

	public RSItem() {}

	public int ID;
	public int x;
	public int y;
	public int anInt1559;
}