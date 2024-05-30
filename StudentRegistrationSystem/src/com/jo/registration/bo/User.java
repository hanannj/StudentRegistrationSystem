package com.jo.registration.bo;


public class User {
	private String username, password, firstName, lastName;

	public User() {}
	
	public User(String fN, String lN, String psw) {
		firstName = fN;
		lastName = lN;
		password = psw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
