package com.runescape.revised;

/**
 * The Damage class used to calculate
 * the damage dealt to an Entity.
 * 
 * @author josh
 *
 */
public class Damage {

	/**
	 * The amount of damage dealt.
	 */
	private byte damageAmount;

	/**
	 * The setter for the damageAmount.
	 * 
	 * @param damageAmount
	 */
	public void setDamageAmount(byte damageAmount) {
		this.damageAmount = damageAmount;
	}

	/**
	 * The getter for the damageAmount.
	 * 
	 * @return damageAmount
	 * 			The damageAmount 
	 */
	public byte getDamageAmount() {
		return damageAmount;
	}
}