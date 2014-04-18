package com.runescape.revised.content.bank;

public class BankPinSystem {
	
	private byte firstNumber;
	private byte secondNumber;
	private byte thirdNumber;
	private byte fourthNumber;
	
	public void setFirstNumber(byte firstNumber) {
		this.firstNumber = firstNumber;
	}
	
	public byte getFirstNumber() {
		return this.firstNumber;
	}

	public void setSecondNumber(byte secondNumber) {
		this.secondNumber = secondNumber;
	}

	public byte getSecondNumber() {
		return this.secondNumber;
	}

	public void setThirdNumber(byte thirdNumber) {
		this.thirdNumber = thirdNumber;
	}

	public byte getThirdNumber() {
		return this.thirdNumber;
	}

	public void setFourthNumber(byte fourthNumber) {
		this.fourthNumber = fourthNumber;
	}

	public byte getFourthNumber() {
		return this.fourthNumber;
	}
}