package com.sjsu.model;

import java.util.Arrays;

/**
 * This will collect final response from all services. 
 * It will store the final order placed and Status.
 * @author navdeepdahiya
 */

public class UserResponse {

	private String userID;
	private String userName;
	private String orderNo;
	private Item [] finalItems;
	private Item [] orderedItems;
	private boolean orderStatus;
	private float totalPrice;
	
	public UserResponse() {
		super();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Item[] getFinalItems() {
		return finalItems;
	}

	public void setFinalItems(Item[] finalItems) {
		this.finalItems = finalItems;
	}

	public Item[] getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Item[] orderedItems) {
		this.orderedItems = orderedItems;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "UserResponse [userID=" + userID + ", userName=" + userName + ", orderNo=" + orderNo + ", finalItems="
				+ Arrays.toString(finalItems) + ", orderedItems=" + Arrays.toString(orderedItems) + ", orderStatus="
				+ orderStatus + ", totalPrice=" + totalPrice + "]";
	}
	
}
