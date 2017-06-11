package com.beans;
public class UserLogin {
	
	public UserLogin(String uid, String passwd) {
		// TODO Auto-generated constructor stub
		this.userName = uid;
		this.password = passwd;
	}
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	
}
