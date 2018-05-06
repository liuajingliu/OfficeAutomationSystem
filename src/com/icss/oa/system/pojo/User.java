package com.icss.oa.system.pojo;

public class User {
	private int userId;
	
	private String userpwd;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userpwd=" + userpwd + "]";
	}

	public User(int userId, String userpwd) {
		super();
		this.userId = userId;
		this.userpwd = userpwd;
	}

	public User(int userId) {
		super();
		this.userId = userId;
	}
	
	
}
