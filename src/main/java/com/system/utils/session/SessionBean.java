package com.system.utils.session;

import java.util.Date;

public class SessionBean {
	private int id;
	private String sessionId;
	private String username;
	private String nickname;
	private Date dieTime;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDieTime() {
		return dieTime;
	}

	public void setDieTime(Date dieTime) {
		this.dieTime = dieTime;
	}

	
}
