package com.runescape.revised.client.newclient.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.runescape.revised.client.newclient.GameClientState;
import com.runescape.revised.client.newclient.Main;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JProgressBar loadingBar;
	private JLabel userLabel;
	private JTextField userTextField;
	private JLabel passLabel;
	private JPasswordField passTextField;
	private JButton loginButton;
	
	public LoginFrame() {	
		JPanel loginPanel = new JPanel();
		this.setUserLabel(new JLabel("Username"));
		this.setUserTextField(new JTextField());
		this.getUserTextField().setColumns(10);
		this.setPassLabel(new JLabel("Password"));
		this.setPassTextField(new JPasswordField());
		this.getPassTextField().setColumns(10);
		this.setLoginButton(new JButton("Login"));
		this.getLoginButton().setEnabled(true);
		this.getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Main.setGameClientState(GameClientState.LOGIN);
				String password = new String(LoginFrame.this.getPassTextField().getPassword());
				new Login(LoginFrame.this, LoginFrame.this.getUserTextField().getText(), password);
			}
		});
		loginPanel.add(this.getUserLabel());
		loginPanel.add(this.getUserTextField());
		loginPanel.add(this.getPassLabel());
		loginPanel.add(this.getPassTextField());
		loginPanel.add(this.getLoginButton());
		this.setLoadingBar(new JProgressBar());
		this.getLoadingBar().setSize(100, 50);
		this.getLoadingBar().setValue(100);
		this.add(this.getLoadingBar(), BorderLayout.NORTH);
		this.add(loginPanel, BorderLayout.SOUTH);
		this.setTitle("RuneScape Login");
		this.setSize(500, 90);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("org.jvnet.substance.skin.BusinessBlackSteelSkin");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		this.setVisible(false);
	}
	
	public void drawText(byte progressionAmount, String text) {
		this.getLoadingBar().setValue(progressionAmount);
		this.getLoadingBar().setString(text);
	}
	
	public void setLoadingBar(JProgressBar loadingBar) {
		this.loadingBar = loadingBar;
	}

	public JProgressBar getLoadingBar() {
		return this.loadingBar;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}
	
	public JLabel getUserLabel() {
		return this.userLabel;
	}

	public void setUserTextField(JTextField userTextField) {
		this.userTextField = userTextField;
	}
	
	public JTextField getUserTextField() {
		return this.userTextField;
	}

	public void setPassLabel(JLabel passLabel) {
		this.passLabel = passLabel;
	}
	
	public JLabel getPassLabel() {
		return this.passLabel;
	}

	public void setPassTextField(JPasswordField passTextField) {
		this.passTextField = passTextField;
	}
	
	public JPasswordField getPassTextField() {
		return this.passTextField;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getLoginButton() {
		return this.loginButton;
	}
}