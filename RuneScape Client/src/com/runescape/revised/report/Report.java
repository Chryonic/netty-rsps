package com.runescape.revised.report;


public class Report {

	private String message;
	private Rule ruleBroken;
	private byte blackMarks;
	
	public Report(String message, Rule ruleBroken, byte blackMarks) {
		this.setMessage(message);
		this.setRuleBroken(ruleBroken);
		this.setBlackMarks(blackMarks);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setRuleBroken(Rule ruleBroken) {
		this.ruleBroken = ruleBroken;
	}
	
	public Rule getRuleBroken() {
		return ruleBroken;
	}
	
	public void setBlackMarks(byte blackMarks) {
		this.blackMarks = blackMarks;
	}
	
	public byte getBlackMarks() {
		return blackMarks;
	}
}