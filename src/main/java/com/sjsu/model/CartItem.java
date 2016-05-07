package com.sjsu.model;

import java.io.Serializable;

public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7186814095670942042L;
	private String name;
	private String id;
	private String desc;
	private double itemPrice;
	private int quantity;
	private double totalPrice;
	private String imgPath;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "CartItem [itemName=" + name + ", itemID=" + id + ", desc="
				+ desc + ", itemPrice=" + itemPrice + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
//		return "{\"name\":\"" + name + "\"" + ",\"id\":\"" + id + "\""
//				+ ",\"desc\":\"" + desc + "\"" + ",\"itemPrice\":" + itemPrice
//				+ ",\"quantity\":" + quantity + ",\"totalPrice\":" + totalPrice
//				+ "}";
//
//	}
//
//	public String toJson() {
//		return "{\"name\":\"" + name + "\"" + ",\"id\":\"" + id + "\""
//				+ ",\"desc\":\"" + desc + "\"" + ",\"itemPrice\":" + itemPrice
//				+ ",\"quantity\":" + quantity + ",\"totalPrice\":" + totalPrice
//				+ "}";
	}

}