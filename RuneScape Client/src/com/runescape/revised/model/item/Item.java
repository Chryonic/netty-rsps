package com.runescape.revised.model.item;

import com.runescape.revised.model.Model;

public abstract class Item extends Model {

	public abstract short getItemID();
	public abstract String getItemName();
	public abstract String getItemDescription();
	public abstract short getLowAlchemyAmount();
	public abstract short getHighAlchemyAmount();
	public abstract short getShopAmount();
	public abstract byte getAttackStab();
	public abstract byte getAttackSlash();
	public abstract byte getAttackCrush();
	public abstract byte getAttackMage();
	public abstract byte getAttackRange();
	public abstract byte getDefenceStab();
	public abstract byte getDefenceSlash();
	public abstract byte getDefenceCrush();
	public abstract byte getDefenceMage();
	public abstract byte getDefenceRange();
	public abstract byte getStrength();
	public abstract byte getPrayer();
}