package com.sjsu.controller;

/**
 * 
 */

import java.sql.SQLException;

import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.impl.LoginServiceImpl;

public class LoginController {
	
	public static void loginCon() {
	String user="admin";
	String password="admin";
	LoginDAO req = new LoginDAO();
	LoginServiceImpl logIml = new LoginServiceImpl();
	req.setName(user);
	req.setPassword(password);
	try {
		System.out.println("Initiating Sign up.\n");
		if(LoginServiceImpl.insertRecordIntoDbUserTable(req)) {
			System.out.println("Sign-up is successful.\n");
		}
		else {
			System.out.println("Sign-up failed.\n");
		}
		System.out.println("Initiating Sign in.\n");
		if(LoginServiceImpl.selectRecordFromDb(user,password)) {
			System.out.println("Log in is successful.\n");
		}
		else {
			System.out.println("Log in failed.\n");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
