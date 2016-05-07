package com.sjsu.controller;

/**
 * 
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ektorp.CouchDbConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.couch.model.Item;
import com.sjsu.couch.repository.CatalogRepository;
import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.impl.LoginServiceImpl;
import com.sjsu.model.UserRequest;

@Controller
@SessionAttributes("items")
public class LoginController {
	
	//Integrating with couch data for final integration.
	@Autowired
	CatalogRepository catalogRepo;
	
	LoginDAO req = new LoginDAO();
	LoginServiceImpl loginImpl = new LoginServiceImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:login";
	}
	
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
		ModelAndView model = new ModelAndView("search");
		
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
				model.addObject("items",catalogRepo.getAll());
				//model.addObject("items", getItemList());
				return model;
				
			}
			else {
			    return new ModelAndView("errorPage");
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
    }
	
	
	public List<Item> getItemList(){
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item("T-shirt", "shirt-id", "Its a big tee", "imgPath", (float) 7.0,8));
		items.add(new Item("Reebok Tee", "rbkId1", "Play Dry", "imgPath", (float) 700.0,100));
		items.add(new Item("Another Reebok tee", "rb2", "Play Ice", "imgPath", (float) 300.0,50));
		items.add(new Item("Puma tee", "rb3", "Play Ice", "imgPath", (float) 300.0,50));
		items.add(new Item("Another Reebok tee", "rb4", "Paly Ice", "imgPath", (float) 300.0,50));
		return items;
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
