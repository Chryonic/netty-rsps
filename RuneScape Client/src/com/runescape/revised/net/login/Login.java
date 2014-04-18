package com.runescape.revised.net.login;

import java.io.IOException;

import com.runescape.CacheArchive;
import com.runescape.SignLink;
import com.runescape.revised.media.IndexedImage;
import com.runescape.revised.client.Model;
import com.runescape.revised.net.netty.Netty;
import com.runescape.revised.filesystem.Decompressor;
import com.runescape.revised.graphics.SceneGraph;
import com.runescape.revised.media.Sprite;

public class Login {

	private String name;
	private String pass;
	private ConnectionType connectionType;
	private String firstMessage;
	private String secondMessage;
	private byte userID;
	private ResponseCode responseCode;
	
	public Login(String name, String pass) {
		this.setName(name);
		this.setPass(pass);
	}
	
	public void login() {
		try {
			new Netty();
			stream.putLEShort(ConnectionType.LOGIN.getConnectionID());
			switch (this.getResponseCode()) {
			case EXCHANGE:
				stream.writeDWord(SignLink.userID);
				stream.writeString(this.getName());
				stream.writeString(this.getPass());
				/** if(flag) {
					aStream_847.putLEShort(ConnectionType.RECONNECTING);
				} else {
					aStream_847.putLEShort(ConnectionType.NEW_CONNECTION);
				} */
				aStream_847.putShort(317);
				aStream_847.putLEShort(lowMem ? 1 : 0);
				this.getResponseCode().setValue(socketStream.read());
			case WAIT:
				new Login(this.getName(), this.getPass());
				return;
			case LOGIN:
				// add in-game things that need to be started up here 
				return;
			case UNKNOWN:
				// login?
				return;
			case INVALID_USER_PASS:
			case ACCOUNT_DISABLED:
			case ALREADY_LOGGED_IN:
			case UPDATE:
			case WORLD_FULL:
			case LOGIN_SERVER_OFFLINE:
			case LIMIT_EXCEEDED:
			case BAD_SESSION_ID:
			case REJECTED_SESSION:
			case MEMBERS_NEEDED:
			case INCOMPLETE_LOGIN:
			case SERVER_UPDATE:
			case LOGIN_ATTEMPTS_EXCEEDED:
			case MEMBERS_ONLY_AREA:
			case INVALID_LOGINSERVER:
				this.setFirstMessage(this.getResponseCode().getFirstResponse());
				this.setSecondMessage(this.getResponseCode().getSecondResponse());
			case TRANSFER:	
				for(int k1 = socketStream.read(); k1 >= 0; k1--)
				{
					loginMessage1 = "You have only just left another world";
					loginMessage2 = "Your profile will be transferred in: " + k1 + " seconds";
					drawLoginScreen(true);
					try {
						Thread.sleep(1000L);
					} catch(Exception _ex) { }
				}
				new Login(this.getName(), this.getPass());
				return;
			case WAIT_AND_COUNT_FAILURES:
				if(i1 == 0) {
					if(loginFailures < 2) {
						try {
							Thread.sleep(2000L);
						} catch(Exception _ex) { }
						loginFailures++;
						new Login(this.getName(), this.getPass());
						return;
					} else {
						this.setFirstMessage("No response from loginserver.");
						this.setSecondMessage("Please wait 1 minute and try again.");
						return;
					}
				} else {
					this.setFirstMessage("No response from server.");
					this.setSecondMessage("Please try using a different world.");
					return;
				}
			case UNEXPECTED_SERVER_RESPONSE:
				this.setFirstMessage(this.getResponseCode().getFirstResponse());
				this.setSecondMessage(this.getResponseCode().getSecondResponse());
				return;
		} catch(IOException _ex) {
			this.setFirstMessage("");
		}
		this.setFirstMessage("Error connecting to server.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	
	public ConnectionType getConnectionType() {
		return this.connectionType;
	}

	public void setFirstMessage(String firstMessage) {
		this.firstMessage = firstMessage;
	}

	public String getFirstMessage() {
		return this.firstMessage;
	}

	public void setSecondMessage(String secondMessage) {
		this.secondMessage = secondMessage;
	}

	public String getSecondMessage() {
		return this.secondMessage;
	}
	
	public void setUserID(byte userID) {
		this.userID = userID;
	}
	
	public byte getUserID() {
		return this.userID;
	}
	
	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	public ResponseCode getResponseCode() {
		return this.responseCode;
	}
}