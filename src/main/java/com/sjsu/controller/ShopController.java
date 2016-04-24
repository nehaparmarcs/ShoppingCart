package com.sjsu.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ektorp.PageRequest;
import org.ektorp.UpdateConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.couch.model.Item;
import com.sjsu.couch.repository.CatalogRepository;
import com.sjsu.model.UserRequest;

public class ShopController {
	
	@Autowired
	CatalogRepository catalogRepo;
	
	/**
	 * This method will return the entire list of item to be rendered to the view
	 * @param m Model object
	 * @param pageLink
	 * @return view to be shown
	 */
	@RequestMapping( value = "browse", method = RequestMethod.GET)
	public String viewAll(Model m, @RequestParam(value = "p", required = false) String pageLink) {
		PageRequest pr = pageLink != null ? PageRequest.fromLink(pageLink) : PageRequest.firstPage(5);
		m.addAttribute(catalogRepo.getAll(pr));
		return "browse";
	}
	
	// ++ ND
	
	
	@RequestMapping( value = "newItem", method = RequestMethod.GET)
	public ModelAndView newPost() {
		return new ModelAndView("newItem", "command", new Item());
	}
	
	@RequestMapping( value = "addItem", method = RequestMethod.POST)
	public String submitPost(@ModelAttribute("command") Item item) {
		if (item.isNew()) {
			item.setId(createId(item.getItemID()));
			catalogRepo.add(item);
		} else {
			catalogRepo.update(item);	
		}
		
		return "newItem";
	}
	
	@ExceptionHandler(UpdateConflictException.class)
	public ModelAndView onUpdateConflictException(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("update_conflict");
		Item existing = catalogRepo.get(req.getParameter("itemID"));
		mav.addObject("command", existing);
		return mav;
	}
	
	private String createId(String itemID) {
		return itemID.replaceAll("\\s", "-");
	}
/*
	@RequestMapping("/browse/{itemId}")
	public ModelAndView viewPost(@PathVariable("itemId") String itemId) {
		ModelAndView model = new ModelAndView("/browse/view");
		model.addObject(catalogRepo.get(itemId));
		return model;
	}
	
	@RequestMapping( value = "/browse/{itemId}/edit", method = RequestMethod.GET)
	public Item editPost(@PathVariable("itemId") String itemId) {
		return catalogRepo.get(itemId);
	}
	*/
	// -- ND
	
	@RequestMapping(value="search")
    public String search(@ModelAttribute("userRequest")UserRequest userRequest, Model model,
   		   BindingResult result) {
		
		Map modelMap = model.asMap();
		//Obtains all the Item elements from couch db
		model.addAttribute("items",catalogRepo.getAll());
		
		return "search";
		
	}
	
	
	
	

}
