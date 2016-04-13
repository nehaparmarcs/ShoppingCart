package com.sjsu.model;

/**
 * Represents a User information throughout the application.
 * ShopManager uses this object to interact with all the services.
 * 
 * @author navdeepdahiya
 */
public class UserRequest {

	private String userID;
	private String userName;
	private String searchText;
	private Cart cart;
	
	public UserRequest() {
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

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "UserRequest [userID=" + userID + ", userName=" + userName + ", searchText=" + searchText + ", cart="
				+ cart + "]";
	}
	
}
