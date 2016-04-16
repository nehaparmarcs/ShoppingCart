package com.sjsu.catalog.service;

import com.sjsu.model.Item;
import com.sjsu.model.UserRequest;
import com.sjsu.model.UserResponse;

/**
 * Allows shoppingManager to browse Item on the basis of searchText entered.
 * 
 * @author neha
 *
 */
public interface ICatalogService {

	/**
	 * Called when user hits the site and chooses to browse for all items.
	 * @param searchText performs the search on the basis of searchText if entered by the user
	 * else returns from popular items default for the page.
	 * @return itemList to display on the page
	 */
	public Item[] browse(String searchText);
	
	/**
	 * This method returns the complete description of an item when it is selected by the User.
	 * @param itemID performs the detailed search on the basis of itemID
	 * @return Items complete description
	 */
	public Item itemDetails(String itemID);
	
	
	
}
