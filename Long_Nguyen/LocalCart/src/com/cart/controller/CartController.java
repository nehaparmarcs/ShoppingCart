package com.cart.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.app.CartDBManager;
import com.sjsu.model.Cart;
import com.sjsu.model.CartItem;
import com.sjsu.model.JsonResponse;

@Controller
public class CartController {
	CartDBManager db = new CartDBManager();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:showform";
	}

	@RequestMapping(value = "/showform", method = RequestMethod.GET)
	public String showForm(Model model) {
		System.out.println("in showForm mapping");
		CartItem item = new CartItem();
		model.addAttribute("itemForm", item);
		boolean error = false;
		String msg = "";
		model.addAttribute("error", error);
		model.addAttribute("errorMsg", msg);
		return "myform";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("SpringWeb") CartItem item,
			Model model) throws Exception {

		Cart cart = db.addCartItem("mark", item);

		if (cart == null) {
			boolean error = true;
			String msg = "add item to cart failed";
			model.addAttribute("error", error);
			model.addAttribute("errorMsg", msg);
			model.addAttribute("itemForm", item);
			return "myform";
		} else {
			boolean error = true;
			String msg = "add item to cart successfully: " + item.toString();
			System.out.println(msg);
			model.addAttribute("error", error);
			model.addAttribute("errorMsg", msg);
			model.addAttribute("itemForm", item);
			return "myform";
		}
	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public String viewCart(Model model) {
		System.out.println("in viewCart mapping");
		Cart cart = db.getCart("mark");
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}

	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	public String removeItem(@RequestBody String reqData, Model model) {
		System.out.println("RemoveItem: " + reqData);
		JSONObject jsonObject = new JSONObject(reqData);
		String id = jsonObject.getString("id");
		Cart cart = null;
		cart = db.deleteCartItem("mark", id);
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}
	
	@RequestMapping(value = "/updateItemQuantity", method = RequestMethod.POST)
	public String updateItemQuantity(@RequestBody String reqData, Model model) {
		System.out.println("updateItemQuantity: " + reqData);
		JSONObject jsonObject = new JSONObject(reqData);
		String id = jsonObject.getString("id");
		int quantity = jsonObject.getInt("quantity");
		Cart cart = null;
		cart = db.updateCartItem("mark", id, quantity);
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}
	
	private void initNumberList(Model model) {
		// TODO Auto-generated method stub
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		numList.add(6);
		numList.add(7);
		numList.add(8);
		numList.add(9);

		model.addAttribute("numberList", numList);
	}

}
