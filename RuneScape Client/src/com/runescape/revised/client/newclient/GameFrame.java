package com.runescape.revised.client.newclient;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GameApplet gameApplet;

	public GameFrame(GameApplet gameApplet) {
		this.setGameApplet(gameApplet);
		this.setTitle("RuneScape Client");
		this.setResizable(false);
		this.setVisible(true);
		this.toFront();
		this.setSize(773, 531);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(this.getGameApplet());
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.BusinessBlackSteelSkin");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics graphics) {
		this.getGameApplet().paint(graphics);
	}
	
	@Override
	public void update(Graphics graphics) {
		this.getGameApplet().paint(graphics);
	}
	
	public void setGameApplet(GameApplet gameApplet) {
		this.gameApplet = gameApplet;
	}
	
	public GameApplet getGameApplet() {
		return this.gameApplet;
	}
}