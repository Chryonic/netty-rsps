package com.runescape.revised.client.newclient;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JApplet;

import com.runescape.revised.media.chat.ChatBox;
import com.runescape.revised.media.map.Compass;
import com.runescape.revised.media.map.MapArea;
import com.runescape.revised.media.tabarea.TabArea;
// import com.runescape.revised.media.threedworld.GameArea;
import com.runescape.revised.media.threedworld.Memory;
import com.runescape.revised.media.threedworld.RevisionType;
import com.runescape.revised.menu.Menu;

public class GameApplet extends JApplet implements MouseListener, MouseMotionListener, KeyListener, WindowListener {

	private static final long serialVersionUID = 1L;
	private ChatBox chatBox = new ChatBox();
	private MapArea mapArea = new MapArea();
	private TabArea tabArea = new TabArea();
	private Compass compass = new Compass();
	// private GameArea gameArea;
	private Memory memory = Memory.LOW;
	private RevisionType revisionType = RevisionType.THREE_ONE_SEVEN;
	private Graphics graphics;
	
	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(this.getChatBox().getImage(), this.getChatBox().getLocation().getX(), this.getChatBox().getLocation().getY(), null);
		graphics.drawImage(this.getMapArea().getImage(), this.getMapArea().getLocation().getX(), this.getMapArea().getLocation().getY(), null);
		graphics.drawImage(this.getTabArea().getImage(), this.getTabArea().getLocation().getX(), this.getTabArea().getLocation().getY(), null);
		graphics.drawImage(this.getCompass().getImage(), this.getCompass().getLocation().getX(), this.getCompass().getLocation().getY(), null);
		// graphics.drawImage(this.getGameArea().getImage(), this.getGameArea().getLocation().getX(), this.getGameArea().getLocation().getY(), null);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			new Menu(this.getGraphics());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setChatBox(ChatBox chatBox) {
		this.chatBox = chatBox;
	}

	public ChatBox getChatBox() {
		return this.chatBox;
	}

	public void setMapArea(MapArea mapArea) {
		this.mapArea = mapArea;
	}

	public MapArea getMapArea() {
		return this.mapArea;
	}

	public void setTabArea(TabArea tabArea) {
		this.tabArea = tabArea;
	}

	public TabArea getTabArea() {
		return this.tabArea;
	}

	public void setCompass(Compass compass) {
		this.compass = compass;
	}

	public Compass getCompass() {
		return this.compass;
	}

	/** public void setGameArea(GameArea gameArea) {
		this.gameArea = gameArea;
	}

	public GameArea getGameArea() {
		return this.gameArea;
	} */

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Memory getMemory() {
		return this.memory;
	}

	public void setRevisionType(RevisionType revisionType) {
		this.revisionType = revisionType;
	}

	public RevisionType getRevisionType() {
		return this.revisionType;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public Graphics getGraphics() {
		return this.graphics;
	}
}