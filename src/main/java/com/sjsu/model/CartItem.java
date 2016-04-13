package com.sjsu.model;

public class CartItem extends Item{
	private long addedTime;
	private int quantity; //quantity of added item

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(long addedTime) {
		this.addedTime = addedTime;
	}
	
}
