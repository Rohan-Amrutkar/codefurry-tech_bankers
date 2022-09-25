package com.codefury.model.beans;

public class User {
	private int id;
	private String name;
	private String role;
	private int telephone;
	private String email;
	private String username;
	private String password;
	
	
	public User() {
		super();
	}


	public User(int id, String name, String role, int telephone, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.telephone = telephone;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + ", telephone=" + telephone + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
