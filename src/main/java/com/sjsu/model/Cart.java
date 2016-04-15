package com.sjsu.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cart {
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

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Cart [items=");
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
