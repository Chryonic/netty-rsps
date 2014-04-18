package com.runescape.revised.media.tabarea.inventory;

import com.runescape.revised.model.item.Item;

public class Slot {

	private Item item;
	
	public Slot(Item item) {
		this.setItem(item);
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}