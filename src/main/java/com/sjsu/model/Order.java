package com.sjsu.model;


import java.util.LinkedList;
import java.util.List;

public class Order {
	private String orderNum;
	private String orderDate;
	private List<CartItem> items;
	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Order() {
		items = new LinkedList<CartItem>();
	}
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Order: orderNum=" + orderNum + " orderDate=" + orderDate + " [items=");
		for (int i = 0; i < items.size(); i++) {
			CartItem c = items.get(i);
			str.append(c.toString());
			if (i < items.size() - 1) {
				str.append(",");
			}
		}
		str.append("]");
		return str.toString();
	}
	
}

