package com.sjsu.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cart {
	private String userId;
	
	private double total;
	
	/*
	 * List of items in the cart.
	 */
	private List<CartItem> itemList;

	public Cart() {
		itemList = new LinkedList<CartItem>();
	}

	public List<CartItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<CartItem> itemList) {
		this.itemList = itemList;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void computeTotal() {
		total = 0;
		for (CartItem ci : itemList) {
			total += ci.getTotalPrice();
		}
	}
	
	

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Cart: user=" + userId + ", total=" + total + ", [items=");
		for (int i = 0; i < itemList.size(); i++) {
			CartItem c = itemList.get(i);
			str.append(c.toString());
			if (i < itemList.size() - 1) {
				str.append(",");
			}
		}
		str.append("]");
		return str.toString();
	}

}
