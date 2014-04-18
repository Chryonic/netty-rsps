package com.runescape.revised.database;

public class Database {

	private String username;
	private String password;
	private static int maxConnections;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public static void setMaxConnections(int maxConnections) {
		Database.maxConnections = maxConnections;
	}
	
	public static int getMaxConnections() {
		return maxConnections;
	}
}