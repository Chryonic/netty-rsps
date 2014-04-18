package com.runescape.revised.content.shop;

public class ShopSystem {

	private static ShopSystem shopSystem;

	public static void setShopSystem(ShopSystem shopSystem) {
		ShopSystem.shopSystem = shopSystem;
	}

	public static ShopSystem getShopSystem() {
		return ShopSystem.shopSystem;
	}
}