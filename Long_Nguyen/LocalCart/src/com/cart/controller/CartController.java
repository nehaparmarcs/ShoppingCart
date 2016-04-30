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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.app.CartDBManager;
import com.sjsu.app.CartManager;
import com.sjsu.app.OrderDBManager;
import com.sjsu.model.Cart;
import com.sjsu.model.CartItem;
import com.sjsu.model.JsonResponse;
import com.sjsu.model.Order;
import com.sjsu.model.OrderList;
import com.sjsu.model.ShoppingCartConstant;

@Controller
public class CartController implements ShoppingCartConstant{
	//CartDBManager db = new CartDBManager();
	CartManager cartMgr = new CartManager();
	
	OrderDBManager orderMgr = new OrderDBManager();

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

		//Cart cart = db.addCartItem("mark", item);
		Cart cart = cartMgr.addCartItem("mark", IDENTIFIED_USER_TYPE, item);

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
	public String viewCart(@RequestParam String userId, Model model) {
		System.out.println("in viewCart mapping " + userId);
		//Cart cart = db.getCart("mark");
		Cart cart = cartMgr.getCart(userId, IDENTIFIED_USER_TYPE);
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}

	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	public String removeItem(@RequestBody String reqData, Model model) {
		System.out.println("RemoveItem: " + reqData);
		JSONObject jsonObject = new JSONObject(reqData);
		String userid = jsonObject.getString("userid");
		String id = jsonObject.getString("id");
		Cart cart = null;
		//cart = db.deleteCartItem(userid, id);
		cart = cartMgr.deleteCartItem(userid, IDENTIFIED_USER_TYPE, id);
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}
	
	@RequestMapping(value = "/updateItemQuantity", method = RequestMethod.POST)
	public String updateItemQuantity(@RequestBody String reqData, Model model) {
		System.out.println("updateItemQuantity: " + reqData);
		JSONObject jsonObject = new JSONObject(reqData);
		String userid = jsonObject.getString("userid");
		String id = jsonObject.getString("id");
		int quantity = jsonObject.getInt("quantity");
		Cart cart = null;
		//cart = db.updateCartItem(userid, id, quantity);
		cart = cartMgr.updateCartItem(userid, IDENTIFIED_USER_TYPE, id, quantity);
		model.addAttribute("cart", cart);
		initNumberList(model);
		return "showcart";
	}
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST)
	public String checkOut(@RequestBody String reqData, Model model) {
		System.out.println("checkOut: " + reqData);
		JSONObject jsonObject = new JSONObject(reqData);
		String userId = jsonObject.getString("userid");
		Cart cart = null;
		//cart = db.updateCartItem(userid, id, quantity);
		cart = cartMgr.getCart(userId, IDENTIFIED_USER_TYPE);
		Order order = orderMgr.createOrder(cart);
		orderMgr.addOrder(order, userId);
		
		//delete checked out cart
		cartMgr.deleteCart(userId, IDENTIFIED_USER_TYPE);
		model.addAttribute("order", order);
		return "orderconfirm";
	}
	
	@RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
	public String orderDetail(@RequestParam String userId, @RequestParam String orderNum, Model model) {
		System.out.println("orderDetail: " + userId + " " + orderNum);
//		JSONObject jsonObject = new JSONObject(reqData);
//		String userId = jsonObject.getString("userid");
		Order order = orderMgr.getOrder(userId, orderNum);
		model.addAttribute("order", order);
		return "orderdetail";
	}
	
	@RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
	public String viewOrders(@RequestParam String userId, Model model) {
		System.out.println("viewOrders: " + userId);
		OrderList orderList = orderMgr.getOrderList(userId);
		model.addAttribute("orderList", orderList);
		return "showorders";
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
