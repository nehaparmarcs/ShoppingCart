package com.sjsu.controller;

import org.ektorp.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjsu.couch.repository.CatalogRepository;

public class ShopController {
	
	@Autowired
	CatalogRepository catalogRepo;
	
	/**
	 * This method will return the entire list of item to be rendered to the view
	 * @param m Model object
	 * @param pageLink
	 * @return view to be shown
	 */
	@RequestMapping( value = "/browse/", method = RequestMethod.GET)
	public String viewAll(Model m, @RequestParam(value = "p", required = false) String pageLink) {
		PageRequest pr = pageLink != null ? PageRequest.fromLink(pageLink) : PageRequest.firstPage(5);
		m.addAttribute(catalogRepo.getAll(pr));
		return "/browse/index";
	}
	
	
	
	
	
	

}
