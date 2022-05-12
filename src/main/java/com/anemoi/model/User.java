package com.anemoi.model;

import java.util.List;

public class User {

	private int uid;
	private String firstname;
	private String lastname;
	private String email;

	public List<User> users;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}

	public User(int uid, String firstname, String lastname, String email) {
		super();
		this.uid = uid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
