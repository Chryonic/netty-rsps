package com.runescape.revised.content.shop;

import com.runescape.revised.system.System;

public class ShopSystem extends System {

	private static ShopSystem shopSystem;

	@Override
	public void executeSystem() {

	}

	public static void setShopSystem(final ShopSystem shopSystem) {
		ShopSystem.shopSystem = shopSystem;
	}

	public static ShopSystem getShopSystem() {
		return ShopSystem.shopSystem;
	}
}