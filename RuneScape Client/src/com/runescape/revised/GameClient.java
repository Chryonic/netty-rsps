package com.runescape.revised;

import java.util.Map;
import java.util.Queue;

import com.runescape.revised.interfaces.Interface;
import com.runescape.revised.media.tabarea.Tab;

public class GameClient {

	private Queue<System> systemQueue;
	// private Pool<System> systemPool;
	private Map<Tab, Interface> tabMap;
	private Map<String, String> chatMap;
	private Queue<String> chatQueue;
	
	public GameClient() {
		// this.setSystemQueue((Queue<System>) new ArrayQueue<System>(0));
		// new Thread(new AppletThread()).start();
		/** byte coreAmount = (byte) Runtime.getRuntime().availableProcessors();
		for (byte b = 0; b <= coreAmount; b++) {
			Thread[] threadAmount = new Thread[b];
			threadAmount[0].start();
			threadAmount[1].start();
		} */
	}

	public void setSystemQueue(Queue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}

	public Queue<System> getSystemQueue() {
		return this.systemQueue;
	}

	public void setTabMap(Map<Tab, Interface> tabMap) {
		this.tabMap = tabMap;
	}

	public Map<Tab, Interface> getTabMap() {
		return this.tabMap;
	}

	public void setChatMap(Map<String, String> chatMap) {
		this.chatMap = chatMap;
	}

	public Map<String, String> getChatMap() {
		return this.chatMap;
	}

	public void setChatQueue(Queue<String> chatQueue) {
		this.chatQueue = chatQueue;
	}

	public Queue<String> getChatQueue() {
		return this.chatQueue;
	}
}