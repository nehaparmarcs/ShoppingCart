package com.sjsu.model;


import java.util.LinkedList;
import java.util.List;

public class Order {
	private String orderNum;
	private int orderStatus;
	private String orderDate;
	private List<Item> items;
	
	public Order() {
		items = new LinkedList<Item>();
	}
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Order: orderNum=" + orderNum + " orderStatus= " + orderStatus + " orderDate=" + orderDate + " [items=");
		for (int i = 0; i < items.size(); i++) {
			Item c = items.get(i);
			str.append(c.toString());
			if (i < items.size() - 1) {
				str.append(",");
			}
		}
		str.append("]");
		return str.toString();
	}
	
}

