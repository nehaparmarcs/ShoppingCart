package com.sjsu.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.couch.model.Item;
import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.impl.LoginServiceImpl;

@Controller
public class DetailsController {

	@RequestMapping(value="details")
    public ModelAndView home(@RequestParam(value = "itemID", required = false) String itemID) {
		
		ModelAndView modelandView = new ModelAndView("detailsPage", "item", getItem());
		modelandView.addObject("item", getItem());
		return modelandView;
		
    }
	
	public Item getItem(){
		return new Item("T-shirt", "shirt-id", "Its a big tee", "imgPath", (float) 7.0,8);
	
	}
	
	

	@RequestMapping(value="detailsPage")
   public ModelAndView home1(@ModelAttribute("user")LoginDAO user,
  		   BindingResult result) {
		System.out.println(user);
		boolean success = false;
		ModelAndView model = new ModelAndView("search");
		
		try {
			
			
			success = LoginServiceImpl.selectRecordFromDb(user.getName(),user.getPassword());
			if(success) {
			
				
			}
			else {
			    return new ModelAndView("errorPage");
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
   }
}
