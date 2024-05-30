package com.jo.registration.boo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	@Id
	private int id;
	private String password, firstName, lastName;

	public User() {}
	
	public User(String fN, String lN, String psw) {
		firstName = fN;
		lastName = lN;
		password = psw;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
