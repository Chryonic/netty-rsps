package com.runescape;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import com.runescape.revised.graphics.image.RSImageProducer;

public class RSApplet extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	public final void createClientFrame(int height, int width) {
		myWidth = width;
		myHeight = height;
		gameFrame = new RSFrame(this, myWidth, myHeight);
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight, getGameComponent());
		startRunnable(this, 1);
	}

	protected final void initClientFrame(int height, int width) {
		myWidth = width;
		myHeight = height;
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight, getGameComponent());
		startRunnable(this, 1);
	}

	@Override
	public void run() {
		getGameComponent().addMouseListener(this);
		getGameComponent().addMouseMotionListener(this);
		getGameComponent().addKeyListener(this);
		getGameComponent().addFocusListener(this);
		if(gameFrame != null)
			gameFrame.addWindowListener(this);
		drawLoadingText(0, "Loading...");
		startUp();
		int opos = 0;
		int ratio = 256;
		int del = 1;
		int count = 0;
		int intex = 0;
		for(int optim = 0; optim < 10; optim++)
			optims[optim] = System.currentTimeMillis();

		while(gameState >= 0) 
		{
			if(gameState > 0)
			{
				gameState--;
				if(gameState == 0)
				{
					exit();
					return;
				}
			}
			ratio = 300;
			del = 1;
			long currentTime = System.currentTimeMillis();
			if(currentTime > optims[opos])
				ratio = (int)((long)(2560 * delayTime) / (currentTime - optims[opos]));
			if(ratio < 25)
				ratio = 25;
			if(ratio > 256)
			{
				ratio = 256;
				del = (int)((long) delayTime - (currentTime - optims[opos]) / 10L);
			}
			if(del > delayTime)
				del = delayTime;
			optims[opos] = currentTime;
			opos = (opos + 1) % 10;
			if(del > 1)
			{
				for(int optim = 0; optim < 10; optim++)
					if(optims[optim] != 0L)
						optims[optim] += del;

			}
			if(del < minDelay)
				del = minDelay;
			try
			{
				Thread.sleep(del);
			}
			catch(InterruptedException _ex)
			{
				intex++;
			}
			for(; count < 256; count += ratio)
			{
				clickType = eventMouseButtonPressed;
				saveClickX = eventClickX;
				saveClickY = eventClickY;
				clickTime = lastClick;
				eventMouseButtonPressed = 0;
				processGameLoop();
				readIndex = writeIndex;
			}

			count &= 0xff;
			if(delayTime > 0)
				fps = (1000 * ratio) / (delayTime * 256);
			processDrawing();
			if(shouldDebug)
			{
				System.out.println("ntime:" + currentTime);
				for(int l2 = 0; l2 < 10; l2++)
				{
					int i3 = ((opos - l2 - 1) + 20) % 10;
					System.out.println("otim" + i3 + ":" + optims[i3]);
				}

				System.out.println("fps:" + fps + " ratio:" + ratio + " count:" + count);
				System.out.println("del:" + del + " deltime:" + delayTime + " mindel:" + minDelay);
				System.out.println("intex:" + intex + " opos:" + opos);
				shouldDebug = false;
				intex = 0;
			}
		}
		if(gameState == -1)
			exit();
	}

	private void exit() {
		gameState = -2;
		cleanUpForQuit();
		if(gameFrame != null) {
			try {
				Thread.sleep(1000L);
			} catch(Exception _ex) {}
			try {
				System.exit(0);
			} catch(Throwable _ex) {}
		}
	}

	public final void method4(int i)
	{
			delayTime = 1000 / i;
	}

	public final void start()
	{
		if(gameState >= 0)
			gameState = 0;
	}

	public final void stop()
	{
		if(gameState >= 0)
			gameState = 4000 / delayTime;
	}

	public final void destroy()
	{
		gameState = -1;
		try
		{
			Thread.sleep(5000L);
		}
		catch(Exception _ex) { }
		if(gameState == -1)
			exit();
	}

	public final void update(Graphics g)
	{
		if(graphics == null)
			graphics = g;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void paint(Graphics g)
	{
		if(graphics == null)
			graphics = g;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void mousePressed(MouseEvent mouseevent)
	{
		int i = mouseevent.getX();
		int j = mouseevent.getY();
		if(gameFrame != null)
		{
			i -= 4;
			j -= 22;
		}
		idleTime = 0;
		eventClickX = i;
		eventClickY = j;
		lastClick = System.currentTimeMillis();
		if(mouseevent.isMetaDown())
		{
			eventMouseButtonPressed = 2;
			mouseButtonPressed = 2;
		} else
		{
			eventMouseButtonPressed = 1;
			mouseButtonPressed = 1;
		}
	}

	public final void mouseReleased(MouseEvent mouseevent)
	{
		idleTime = 0;
		mouseButtonPressed = 0;
	}

	public final void mouseClicked(MouseEvent mouseevent)
	{
	}

	public final void mouseEntered(MouseEvent mouseevent)
	{
	}

	public final void mouseExited(MouseEvent mouseevent)
	{
		idleTime = 0;
		mouseEventX = -1;
		mouseEventY = -1;
	}

	public final void mouseDragged(MouseEvent mouseevent)
	{
		int x = mouseevent.getX();
		int y = mouseevent.getY();
		if(gameFrame != null)
		{
			x -= 4;
			y -= 22;
		}
		idleTime = 0;
		mouseEventX = x;
		mouseEventY = y;
	}

	public final void mouseMoved(MouseEvent mouseevent)
	{
		int x = mouseevent.getX();
		int y = mouseevent.getY();
		if(gameFrame != null)
		{
			x -= 4;
			y -= 22;
		}
		idleTime = 0;
		mouseEventX = x;
		mouseEventY = y;
	}

	public final void keyPressed(KeyEvent keyevent)
	{
		idleTime = 0;
		int keyCode = keyevent.getKeyCode();
		int keyChar = keyevent.getKeyChar();
		if(keyChar < 30)
			keyChar = 0;
		if(keyCode == 37)
			keyChar = 1;
		if(keyCode == 39)
			keyChar = 2;
		if(keyCode == 38)
			keyChar = 3;
		if(keyCode == 40)
			keyChar = 4;
		if(keyCode == 17)
			keyChar = 5;
		if(keyCode == 8)
			keyChar = 8;
		if(keyCode == 127)
			keyChar = 8;
		if(keyCode == 9)
			keyChar = 9;
		if(keyCode == 10)
			keyChar = 10;
		if(keyCode >= 112 && keyCode <= 123)
			keyChar = (1008 + keyCode) - 112;
		if(keyCode == 36)
			keyChar = 1000;
		if(keyCode == 35)
			keyChar = 1001;
		if(keyCode == 33)
			keyChar = 1002;
		if(keyCode == 34)
			keyChar = 1003;
		if(keyChar > 0 && keyChar < 128)
			keyArray[keyChar] = 1;
		if(keyChar > 4)
		{
			charQueue[writeIndex] = keyChar;
			writeIndex = writeIndex + 1 & 0x7f;
		}
	}

	public final void keyReleased(KeyEvent keyevent)
	{
		idleTime = 0;
		int keyCode = keyevent.getKeyCode();
		char keyChar = keyevent.getKeyChar();
		if(keyChar < '\036')
			keyChar = '\0';
		if(keyCode == 37)
			keyChar = '\001';
		if(keyCode == 39)
			keyChar = '\002';
		if(keyCode == 38)
			keyChar = '\003';
		if(keyCode == 40)
			keyChar = '\004';
		if(keyCode == 17)
			keyChar = '\005';
		if(keyCode == 8)
			keyChar = '\b';
		if(keyCode == 127)
			keyChar = '\b';
		if(keyCode == 9)
			keyChar = '\t';
		if(keyCode == 10)
			keyChar = '\n';
		if(keyChar > 0 && keyChar < '\200')
			keyArray[keyChar] = 0;
	}

	public final void keyTyped(KeyEvent keyevent) {}

	final int readChar()
	{
		int character = -1;
		if(writeIndex != readIndex)
		{
			character = charQueue[readIndex];
			readIndex = readIndex + 1 & 0x7f;
		}
		return character;
	}

	public final void focusGained(FocusEvent focusevent) {
		awtFocus = true;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void focusLost(FocusEvent focusevent) {
		awtFocus = false;
		for(int i = 0; i < 128; i++)
			keyArray[i] = 0;

	}

	public final void windowActivated(WindowEvent windowevent) {}

	public final void windowClosed(WindowEvent windowevent) {}

	public final void windowClosing(WindowEvent windowevent) {
		destroy();
	}

	public final void windowDeactivated(WindowEvent windowevent) {}

	public final void windowDeiconified(WindowEvent windowevent) {}

	public final void windowIconified(WindowEvent windowevent) {}

	public final void windowOpened(WindowEvent windowevent) {}

	void startUp() {}

	void processGameLoop() {}

	void cleanUpForQuit() {}

	void processDrawing() {}

	void raiseWelcomeScreen() {}

	Component getGameComponent() {
		if(gameFrame != null)
			return gameFrame;
		else
			return this;
	}

	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}

	void drawLoadingText(int i, String s)
	{
		while(graphics == null)
		{
			graphics = getGameComponent().getGraphics();
			try
			{
				getGameComponent().repaint();
			}
			catch(Exception _ex) { }
			try
			{
				Thread.sleep(1000L);
			}
			catch(Exception _ex) { }
		}
		Font font = new Font("Helvetica", 1, 13);
		FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
		Font font1 = new Font("Helvetica", 0, 13);
		getGameComponent().getFontMetrics(font1);
		if(shouldClearScreen)
		{
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, myWidth, myHeight);
			shouldClearScreen = false;
		}
		Color color = new Color(140, 17, 17);
		int j = myHeight / 2 - 18;
		graphics.setColor(color);
		graphics.drawRect(myWidth / 2 - 152, j, 304, 34);
		graphics.fillRect(myWidth / 2 - 150, j + 2, i * 3, 30);
		graphics.setColor(Color.black);
		graphics.fillRect((myWidth / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		graphics.drawString(s, (myWidth - fontmetrics.stringWidth(s)) / 2, j + 22);
	}

	public RSApplet() {
		delayTime = 20;
		minDelay = 1;
		optims = new long[10];
		shouldDebug = false;
		shouldClearScreen = true;
		awtFocus = true;
		keyArray = new int[128];
		charQueue = new int[128];
	}

	public int gameState;
	public int delayTime;
	public int minDelay;
	public final long[] optims;
	public int fps;
	public boolean shouldDebug;
	public int myWidth;
	public int myHeight;
	public Graphics graphics;
	protected RSImageProducer fullGameScreen;
	protected RSFrame gameFrame;
	private boolean shouldClearScreen;
	protected boolean awtFocus;
	public int idleTime;
	protected int mouseButtonPressed;
	public int mouseEventX;
	public int mouseEventY;
	public int eventMouseButtonPressed;
	public int eventClickX;
	public int eventClickY;
	public long lastClick;
	public int clickType;
	public int saveClickX;
	public int saveClickY;
	public long clickTime;
	protected final int[] keyArray;
	public final int[] charQueue;
	public int readIndex;
	public int writeIndex;
	public static int anInt34;
}