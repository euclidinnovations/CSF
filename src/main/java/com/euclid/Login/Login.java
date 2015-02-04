package com.euclid.Login;

public class Login{
	private String userid;
	private String password;
	
	
	public void setUserId(String userid){
		this.userid=userid;
	}
	
	public String getUserId(){
		return userid;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return password;
	}
}