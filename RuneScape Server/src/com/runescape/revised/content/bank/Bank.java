package com.runescape.revised.content.bank;

public class Bank {

	private static BankPinSystem bankPinSystem;
	private BankTab bankTabs;
	
	public Bank() {
		
	}

	public void setBankPinSystem(BankPinSystem bankPinSystem) {
		Bank.bankPinSystem = bankPinSystem;
	}

	public BankPinSystem getBankPinSystem() {
		return Bank.bankPinSystem;
	}

	public void setBankTabs(BankTab bankTabs) {
		this.bankTabs = bankTabs;
	}

	public BankTab getBankTabs() {
		return this.bankTabs;
	}
}