package com.runescape.revised.model.entity.update.impl;

import com.runescape.revised.model.entity.Gender;

public class Appearance {

	private Gender gender;
	private byte chest;
	private byte arms;
	private byte legs;
	private byte head;
	private byte hands;
	private byte feet;
	private byte beard;
	private byte hairColor;
	private byte torsoColor;
	private byte legColor;
	private byte feetColor;
	private byte skinColor;
	
	public Appearance() {
		this.setGender(Gender.MALE);
		this.setHead((byte) 0);
		this.setChest((byte) 18);
		this.setArms((byte) 26);
		this.setHands((byte) 33);
		this.setLegs((byte) 36);
		this.setFeet((byte) 42);
		this.setBeard((byte) 10);
		this.setHairColor((byte) 7);
		this.setTorsoColor((byte) 8);
		this.setLegColor((byte) 9);
		this.setFeetColor((byte) 5);
		this.setSkinColor((byte) 0);
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	public void setChest(byte chest) {
		this.chest = chest;
	}

	public byte getChest() {
		return chest;
	}

	public void setArms(byte arms) {
		this.arms = arms;
	}

	public byte getArms() {
		return arms;
	}

	public void setLegs(byte legs) {
		this.legs = legs;
	}

	public byte getLegs() {
		return legs;
	}

	public void setHead(byte head) {
		this.head = head;
	}

	public byte getHead() {
		return head;
	}

	public void setHands(byte hands) {
		this.hands = hands;
	}

	public byte getHands() {
		return hands;
	}

	public void setFeet(byte feet) {
		this.feet = feet;
	}

	public byte getFeet() {
		return feet;
	}

	public void setBeard(byte beard) {
		this.beard = beard;
	}

	public byte getBeard() {
		return beard;
	}

	public void setHairColor(byte hairColor) {
		this.hairColor = hairColor;
	}

	public byte getHairColor() {
		return hairColor;
	}

	public void setTorsoColor(byte torsoColor) {
		this.torsoColor = torsoColor;
	}

	public byte getTorsoColor() {
		return torsoColor;
	}

	public void setLegColor(byte legColor) {
		this.legColor = legColor;
	}

	public byte getLegColor() {
		return legColor;
	}

	public void setFeetColor(byte feetColor) {
		this.feetColor = feetColor;
	}

	public byte getFeetColor() {
		return feetColor;
	}

	public void setSkinColor(byte skinColor) {
		this.skinColor = skinColor;
	}

	public byte getSkinColor() {
		return skinColor;
	}
}