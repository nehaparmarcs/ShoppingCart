package com.sjsu.couch.model;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

public class Item  extends CouchDbDocument {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@TypeDiscriminator
	private String itemID;
	private String desc;
	private String imgPath;
	private Float itemPrice;
	private int quantity;
	private String category;
	
	
	
	public Item(String name, String itemID, String desc, String imgPath, Float itemPrice, int quantity) {
		super();
		this.name = name;
		this.itemID = itemID;
		this.desc = desc;
		this.imgPath = imgPath;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}
	public Item() {
		super();
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", itemID=" + itemID + ", desc=" + desc + ", imgPath=" + imgPath + ", itemPrice="
				+ itemPrice + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	@Override
	public void setRevision(String s) {
		// downstream code does not like revision set to emtpy string, which Spring does when binding
		if (s != null && !s.isEmpty()) super.setRevision(s);
	}
	
	
}
