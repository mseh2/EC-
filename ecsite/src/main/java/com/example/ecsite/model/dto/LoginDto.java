package com.example.ecsite.model.dto;

import com.example.ecsite.model.entity.User;

public class LoginDto {

	private long Id;
	private String userName;
	private String password;
	private String fullName;

	public LoginDto() {
	}

	public LoginDto(User user) {
		this.Id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.fullName = user.getFullName();
	}
	
	public LoginDto(long Id, String userName, String password, String fullName) {
		this.Id = Id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}
