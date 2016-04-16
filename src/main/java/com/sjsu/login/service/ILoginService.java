package com.sjsu.login.service;

/**
 * Service for login operations
 * @author navdeepdahiya
 *
 */

public interface ILoginService {

	/**
	 * Authenticates a user who logs in with required details.
	 * @return true if the user is authentic false otherwise
	 */
	public boolean authenticate();
	
	/**
	 * Creates a user.
	 * @return returns true if user creation was successful
	 */
	public boolean createUser();
	
}
