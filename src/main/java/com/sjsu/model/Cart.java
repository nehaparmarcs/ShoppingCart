package com.sjsu.model;

import java.util.Arrays;
/**
 * Represents a shopping cart for each user. It is associated with User Session in
 * a UserRequest Object.
 * 
 * @author navdeepdahiya
 *
 */
public class Cart {
	/*
	 * List of items in the cart.
	 */
	private Item [] items;

	public Cart() {
		super();
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [items=" + Arrays.toString(items) + "]";
	}
	
}
