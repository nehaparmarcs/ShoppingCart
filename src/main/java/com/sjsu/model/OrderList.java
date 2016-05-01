package com.sjsu.model;

import java.util.LinkedList;
import java.util.List;

public class OrderList {
	private String userId;

	private List<Order> orders;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderList() {
		orders = new LinkedList<Order>();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("OrderList: userid=" + userId + " [orders=");
		for (int i = 0; i < orders.size(); i++) {
			Order c = orders.get(i);
			str.append(c.toString());
			if (i < orders.size() - 1) {
				str.append(",");
			}
		}
		str.append("]");
		return str.toString();
	}

}
