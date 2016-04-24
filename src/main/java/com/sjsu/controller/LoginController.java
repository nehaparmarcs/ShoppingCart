package com.sjsu.controller;

/**
 * 
 */

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.impl.LoginServiceImpl;
import com.sjsu.model.UserRequest;

@Controller
public class LoginController {
	
	LoginDAO req = new LoginDAO();
	LoginServiceImpl loginImpl = new LoginServiceImpl();
	
	@RequestMapping(value="login")
     public ModelAndView home() {
		//System.out.println(user);
		
		ModelAndView modelandView 
        = new ModelAndView("login", "user", new LoginDAO());
		
		return modelandView;

     }
	
	@RequestMapping(value="login1")
    public ModelAndView home1(@ModelAttribute("user")LoginDAO user,
   		   BindingResult result) {
		System.out.println(user);
		boolean success = false;
		
		
		try {
			/*success = LoginServiceImpl.insertRecordIntoDbUserTable(user);
			if(success) {
				
				return new ModelAndView("welcome");
				
			}
			else {
			    return new ModelAndView("errorPage");
				
				System.out.println("Sign-up failed.\n");
			}*/
			
			
			success = LoginServiceImpl.selectRecordFromDb(user.getName(),user.getPassword());
			if(success) {
				
				return new ModelAndView("search", "userRequest", new UserRequest());
				
			}
			else {
			    return new ModelAndView("errorPage");
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
    }
	
	
	/*
	
	@RequestMapping("/login")
	public void loginCon() {
	String user="admin";
	String password="admin";
	
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
	return "login.page";
}
	*/
	
}
