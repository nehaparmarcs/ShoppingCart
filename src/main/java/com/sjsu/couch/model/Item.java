package com.sjsu.couch.model;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

public class Item  extends CouchDbDocument {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@TypeDiscriminator
	private String itemID;
	private String desc;
	private Float itemPrice;
	private int quantity;
	
	
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
	
	@Override
	public void setRevision(String s) {
		// downstream code does not like revision set to emtpy string, which Spring does when binding
		if (s != null && !s.isEmpty()) super.setRevision(s);
	}
	
	
}
