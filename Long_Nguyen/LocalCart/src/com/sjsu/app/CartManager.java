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
	 * Store a cart. userType is refered to USER_TYPE in ShoppingCartConstant
	 */
	public void storeCart(int userType, Cart cart) {
		if (userType == ANONYMOUS_USER_TYPE) {
			addAnonymousCart(cart);
		} else {
			db.storeCart(cart);
		}
	}

	/*
	 * delete a cart. userType is refered to USER_TYPE in ShoppingCartConstant
	 */
	public void deleteCart(String userId, int userType) {
		if (userType == ANONYMOUS_USER_TYPE) {
			deleteAnonymousCart(userId);
		} else {
			db.deleteCart(userId);
		}
	}

	private void deleteAnonymousCart(String userId) {
		// TODO Auto-generated method stub
		anonymousCartMap.remove(userId);
	}

	private void addAnonymousCart(Cart cart) {
		// TODO Auto-generated method stub
		anonymousCartMap.put(cart.getUserId(), cart);
	}

	// private void doAddItem(Cart cart, CartItem item) {
	// List<CartItem> items = cart.getItemList();
	// for (CartItem i : items) {
	// if (i.getId().equals(item.getId())) {
	// i.setQuantity(i.getQuantity() + 1);
	// return;
	// }
	// }
	// items.add(item);
	// }

	// private void doDeleteItem(Cart cart, CartItem item) {
	// // TODO Auto-generated method stub
	// List<CartItem> itemList = cart.getItemList();
	// for (int i = 0; i < itemList.size(); i++) {
	// CartItem cartItem = itemList.get(i);
	// if (cartItem.getId().equals(item.getId())) {
	// itemList.remove(i);
	// return;
	// }
	// }
	// }
}
