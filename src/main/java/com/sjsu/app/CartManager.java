package com.sjsu.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sjsu.model.*;

public class CartManager implements ShoppingCartConstant {

	Map<String, Cart> anonymousCartMap;
	CartDBManager db;

	public CartManager() {
		anonymousCartMap = new HashMap<String, Cart>();
		db = new CartDBManager();
	}

	/*
	 * get Cart for a user. userType is refered to USER_TYPE in
	 * ShoppingCartConstant
	 */
	public Cart getCart(String userId, int userType) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return anonymousCartMap.get(userId);
		} else {
			return db.getCart(userId);
		}
	}

	/*
	 * add an item to the user's cart. userType is refered to USER_TYPE in
	 * ShoppingCartConstant
	 */
	public Cart addCartItem(String userId, int userType, CartItem item) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return addAnonymousCartItem(userId, item);
		} else {
			return db.addCartItem(userId, item);
		}
	}

	/*
	 * delete an item in user's cart. userType is refered to USER_TYPE in
	 * ShoppingCartConstant
	 */
	public Cart deleteCartItem(String userId, int userType, CartItem item) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return deleteAnonymousCartItem(userId, item);
		} else {
			return db.deleteCartItem(userId, item);
		}
	}

	private Cart deleteAnonymousCartItem(String userId, CartItem item) {
		// TODO Auto-generated method stub
		Cart cart = anonymousCartMap.get(userId);
		if (cart == null) {
			// print error log
		} else {
			doDeleteItem(cart, item);
		}
		return cart;
	}

	private Cart addAnonymousCartItem(String userId, CartItem item) {
		// TODO Auto-generated method stub
		Cart cart = anonymousCartMap.get(userId);
		if (cart == null) {
			cart = new Cart();
			doAddItem(cart, item);
			anonymousCartMap.put(userId, cart);
		} else {
			doAddItem(cart, item);
		}
		return cart;
	}

	private void doAddItem(Cart cart, CartItem item) {
		List<CartItem> items = cart.getItemList();
		for (CartItem i : items) {
			if (i.getId().equals(item.getId())) {
				i.setQuantity(i.getQuantity() + 1);
				return;
			}
		}
		items.add(item);
	}

	private void doDeleteItem(Cart cart, CartItem item) {
		// TODO Auto-generated method stub
		List<CartItem> itemList = cart.getItemList();
		for (int i = 0; i < itemList.size(); i++) {
			CartItem cartItem = itemList.get(i);
			if (cartItem.getId().equals(item.getId())) {
				itemList.remove(i);
				return;
			}
		}
	}
}
