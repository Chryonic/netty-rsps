package com.runescape.revised.content.interfaces;

public class Inventory extends Interface {


	
private byte[] inventoryAmount;


	public Inventory() {

		this.setInventoryAmount(new byte[28]);

	}

	@Override

	public int getID() {

		// TODO Auto-generated method stub

		return 0;

	}



	public void setInventoryAmount(byte[] inventoryAmount) {

		this.inventoryAmount = inventoryAmount;

	}



	public byte[] getInventoryAmount() {

		return this.inventoryAmount;

	}
}