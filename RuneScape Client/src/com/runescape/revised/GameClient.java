package com.runescape.revised;

import java.util.Map;
import java.util.Queue;

import com.runescape.revised.interfaces.Interface;
import com.runescape.revised.media.tabarea.Tab;

/**
 * The GameClient class used to represent
 * a Client in RuneScape.
 * 
 * @author josh
 *
 */
public class GameClient {

	/**
	 * The Queue of Systems.
	 */
	private Queue<System> systemQueue;
	
	/**
	 * A Pool of Systems.
	 */
	// private Pool<System> systemPool;
	
	/**
	 * A Map of the interfaces for each
	 * tab.
	 */
	private Map<Tab, Interface> tabMap;
	
	/**
	 * A Map for the messages and all the
	 * player names.
	 */
	private Map<String, String> chatMap;
	
	/**
	 * A Queue of chat messages.
	 */
	private Queue<String> chatQueue;
	
	/**
	 * The GameClient constructor.
	 */
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

	/**
	 * The setter for the SystemQueue instance.
	 * 
	 * @param systemQueue
	 * 			The Queue of Systems.
	 */
	public void setSystemQueue(Queue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}

	/**
	 * The getter for the SystemQueue instance.
	 * 
	 * @return systemQueue
	 * 			The Queue of Systems.
	 */
	public Queue<System> getSystemQueue() {
		return this.systemQueue;
	}

	/**
	 * The setter for the Map instance.
	 * 
	 * @return tabMap
	 * 			The Map.
	 */
	public void setTabMap(Map<Tab, Interface> tabMap) {
		this.tabMap = tabMap;
	}

	/**
	 * The getter for the Map instance.
	 * 
	 * @return tabMap
	 * 			The Map instance.
	 */
	public Map<Tab, Interface> getTabMap() {
		return this.tabMap;
	}

	/**
	 * The setter for the Map instance.
	 * 
	 * @return chatMap
	 * 			The Map parameter.
	 */
	public void setChatMap(Map<String, String> chatMap) {
		this.chatMap = chatMap;
	}

	/**
	 * The getter for the Map instance.
	 * 
	 * @return chatMap
	 * 			The Map instance.
	 */
	public Map<String, String> getChatMap() {
		return this.chatMap;
	}

	/**
	 * The getter for the Queue instance.
	 * 
	 * @return chatQueue
	 * 			The Queue parameter.
	 */
	public void setChatQueue(Queue<String> chatQueue) {
		this.chatQueue = chatQueue;
	}

	/**
	 * The getter for the Queue instance.
	 * 
	 * @return chatQueue
	 * 			The Queue instance.
	 */
	public Queue<String> getChatQueue() {
		return this.chatQueue;
	}
}