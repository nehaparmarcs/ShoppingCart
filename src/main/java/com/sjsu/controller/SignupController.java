package com.sjsu.controller;

/**
 * 
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.couch.model.Item;
import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.impl.LoginServiceImpl;
import com.sjsu.model.UserRequest;

@Controller

public class SignupController {
	
	LoginDAO req = new LoginDAO();
	LoginServiceImpl loginImpl = new LoginServiceImpl();
	@RequestMapping(value="signup")
    public ModelAndView home() {
		//System.out.println(user);
		
		ModelAndView modelandView 
       = new ModelAndView("signup", "user", new LoginDAO());
		
		return modelandView;

    }

	@RequestMapping(value="signup1")
	
    public ModelAndView home1(@ModelAttribute("user")LoginDAO user,
   		   BindingResult result) {
		System.out.println(user);
		boolean success = false;
		ModelAndView model = new ModelAndView("search");
		
		try {
			success = LoginServiceImpl.insertRecordIntoDbUserTable(user);
			if(success) {
				
				return new ModelAndView("login");
				
			}
			else {
			    return new ModelAndView("errorPage");
				
				//System.out.println("Sign-up failed.\n");
			}}
		catch (SQLException e) {
			e.printStackTrace();
		}return null;}
}
	
	
	