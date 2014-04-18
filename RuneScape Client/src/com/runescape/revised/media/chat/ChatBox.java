package com.runescape.revised.media.chat;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public class ChatBox extends Sprite {
	
	private String[] names;
	private Queue<ChatMessage> chatMessageQueue;
	private ChatButton[] chatButtons;
	
	public ChatBox() {
		this.setNames(new String[100]);
		this.setChatMessageQueue(new LinkedList<ChatMessage>());
		this.setChatButtons(new ChatButton[4]);
		for (byte b = 0; b < 3; b++) {
			this.getChatButtons()[b].setChatButtonStatus(ChatButtonStatus.ON);
		}
		this.getChatButtons()[0].setText("Public Chat");
		this.getChatButtons()[1].setText("Private Chat");
		this.getChatButtons()[2].setText("Trade/Compete");
		this.getChatButtons()[3].setText("Report Abust");
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location((short) 0, (short) 363, (byte) -1);
	}

	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return LocationArea.CHAT;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("./images/chatarea.png").getImage();
	}

	@Override
	public Image getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getClickedImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getNames() {
		return this.names;
	}

	public void setChatMessageQueue(Queue<ChatMessage> chatMessageQueue) {
		this.chatMessageQueue = chatMessageQueue;
	}

	public Queue<ChatMessage> getChatMessageQueue() {
		return this.chatMessageQueue;
	}

	public void setChatButtons(ChatButton[] chatButtons) {
		this.chatButtons = chatButtons;
	}

	public ChatButton[] getChatButtons() {
		return this.chatButtons;
	}
}