package com.myproject.go.model;

public class LoginSchema {
	
	private String userName;
	private String password;
	public LoginSchema(String userName,String password) {
		setUserName(userName);
		setPassword(password);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
