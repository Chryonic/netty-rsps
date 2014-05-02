package com.runescape.revised.media.tabarea.inventory;

import com.runescape.revised.model.item.Item;

public class Slot {

	private Item inventoryItem;

	public Slot(final Item inventoryItem) {
		this.setItem(inventoryItem);
	}

	public void setItem(final Item inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public Item getItem() {
		return this.inventoryItem;
	}
}