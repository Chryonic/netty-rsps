package com.runescape.revised.media.tabarea.inventory;

import java.awt.Image;

import com.runescape.revised.media.tabarea.Tab;
import com.runescape.revised.model.item.Item;

public class InventoryTab extends Tab {
	
	private Slot[] slots;
	
	public InventoryTab() {
		this.setSlots(new Slot[27]);
	}
	
	public void switchItems(Item firstItem, Item secondItem) {
		
	}
	
	public void addItem(Item item) {
		
	}
	
	public void removeItem(Item item) {
		
	}

	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}

	@Override
	public int getInterfaceID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Slot[] getSlots() {
		return this.slots;
	}

	@Override
	public Image getClickedImage() {
		// TODO Auto-generated method stub
		return null;
	}
}