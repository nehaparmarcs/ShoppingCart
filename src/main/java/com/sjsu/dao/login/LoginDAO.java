package com.sjsu.dao.login;

/**
 * Mapping of database table fields
 * @author navdeepdahiya
 *
 */

public class LoginDAO {

	private String name;
	private String password;
	
	public LoginDAO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDAO [name=" + name + ", password=" + password + "]";
	}
	
}
