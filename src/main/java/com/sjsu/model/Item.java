package com.sjsu.model;

public class Item {

	private String itemName;
	private String itemID;
	private String desc;
	private Float itemPrice;
	private int quantity;

	public Item() {
		super();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemID=" + itemID + ", desc=" + desc + ", itemPrice=" + itemPrice
				+ ", quantity=" + quantity + "]";
	}

	
}
