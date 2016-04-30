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
			return getAnonymousCart(userId);

		} else {
			return db.getCart(userId);
		}
	}

	private Cart getAnonymousCart(String userId) {
		// TODO Auto-generated method stub
		Cart cart = anonymousCartMap.get(userId);
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
		}
		return cart;
	}

	/*
	 * Store a cart. userType is refered to USER_TYPE in ShoppingCartConstant
	 */
	public void storeCart(int userType, Cart cart) {
		if (userType == ANONYMOUS_USER_TYPE) {
			storeAnonymousCart(cart);
		} else {
			db.storeCart(cart);
		}
	}

	private void storeAnonymousCart(Cart cart) {
		// TODO Auto-generated method stub
		anonymousCartMap.put(cart.getUserId(), cart);
	}

	/*
	 * delete a cart. userType is refered to USER_TYPE in ShoppingCartConstant
	 */
	public void deleteCart(String userId, int userType) {
		if (userType == ANONYMOUS_USER_TYPE) {
			anonymousCartMap.remove(userId);
		} else {
			db.deleteCart(userId);
		}
	}

	public Cart addCartItem(String userId, int userType, CartItem item) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return addAnonymousCartItem(userId, item);
		} else {
			return db.addCartItem(userId, item);
		}
	}

	private Cart addAnonymousCartItem(String userId, CartItem item) {
		// TODO Auto-generated method stub
		System.out.println("Request addAnonymousCartItem, userId: " + userId);
		Cart cart = null;
		// get the Cart from DB
		cart = getAnonymousCart(userId);
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(userId);
		}
		System.out.println("Anonymous Cart before update, userId: " + userId
				+ " Cart: " + cart.toString());
		List<CartItem> dbItems = cart.getItemList();

		boolean isContain = false;
		for (CartItem dbItem : dbItems) {
			if (item.getId().equals(dbItem.getId())) {
				isContain = true;
				dbItem.setQuantity(dbItem.getQuantity() + item.getQuantity());
				dbItem.setTotalPrice(dbItem.getItemPrice()
						* dbItem.getQuantity());
			}
		}
		if (!isContain) {
			item.setTotalPrice(item.getItemPrice() * item.getQuantity());
			dbItems.add(item);
		}
		// re-compute the Total
		cart.computeTotal();
		// store the Cart to DB again
		storeAnonymousCart(cart);
		System.out.println("Anonymous Cart after update, userId: " + userId
				+ " Cart: " + cart.toString());
		return cart;
	}

	public Cart deleteCartItem(String userId, int userType, String id) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return deleteAnonymousCartItem(userId, id);
		} else {
			return db.deleteCartItem(userId, id);
		}
	}

	private Cart deleteAnonymousCartItem(String userId, String id) {
		// TODO Auto-generated method stub
		System.out.println("Request deleteAnonymousCartItem, userId: " + userId
				+ " itemid: " + id);
		Cart cart = null;
		// get the Cart from DB
		cart = getAnonymousCart(userId);
		if (cart == null) {
			System.out.println("ERROR: remove item in an empty Cart!!!");
			return cart;
		}
		System.out.println("Anonymous Cart before update, userId: " + userId
				+ " Cart: " + cart.toString());
		List<CartItem> dbItems = cart.getItemList();
		for (CartItem dbItem : dbItems) {
			if (id.equals(dbItem.getId())) {
				dbItems.remove(dbItem);
				break;
			}
		}
		// re-compute the Total
		cart.computeTotal();
		// store the Cart to DB again
		storeAnonymousCart(cart);
		System.out.println("Anonymous Cart after update, userId: " + userId
				+ " Cart: " + cart.toString());
		return cart;
	}
	
	public Cart updateCartItem(String userId, int userType, String id, int quantity) {
		if (userType == ANONYMOUS_USER_TYPE) {
			return updateAnonymousCartItem(userId, id, quantity);
		} else {
			return db.updateCartItem(userId, id, quantity);
		}
	}

	private Cart updateAnonymousCartItem(String userId, String id, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("Request updateAnonymousCartItem, userId: " + userId
				+ ", id: " + id + ", quantity: " + quantity);
		Cart cart = null;
		// get the Cart from DB
		cart = getAnonymousCart(userId);
		if (cart == null) {
			System.out
					.println("ERROR: updateCartItem item in an empty Cart!!!");
			return cart;
		}
		System.out.println("AnonymousCart before update, userId: " + userId
				+ " Cart: " + cart.toString());
		List<CartItem> dbItems = cart.getItemList();
		for (CartItem dbItem : dbItems) {
			if (id.equals(dbItem.getId())) {
				dbItem.setQuantity(quantity);
				dbItem.setTotalPrice(dbItem.getItemPrice()
						* dbItem.getQuantity());
				break;
			}
		}
		// re-compute the Total
		cart.computeTotal();
		// store the Cart to DB again
		storeAnonymousCart(cart);
		System.out.println("AnonymousCart after update, userId: " + userId
				+ " Cart: " + cart.toString());
		return cart;
	}

}
