package com.sjsu.dao.login;

/**
 * Mapping of database table fields
 * @author navdeepdahiya
 *
 */

public class LoginDAO {

	private String name;
	private String password;
	private String fname;
	private String email;
	private String contact;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

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