package com.example.ecsite.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user") // どのテーブルの実態なのか
public class User {

	@Id // プライマリーキーであることを指す
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DBに主キー生成を委任する
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "is_admin")
	private int isAdmin;

	public User() {
	}

	public User(long id, String userName, String password, String fullName, int isAdmin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isAdmin = isAdmin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
