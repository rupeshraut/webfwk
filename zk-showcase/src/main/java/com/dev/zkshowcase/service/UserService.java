package com.dev.zkshowcase.service;

import java.util.Collection;

import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.model.User;

public interface UserService {

	/**
	 * List users.
	 * 
	 * @return the list
	 */
	Collection<User> listUsers();

	/**
	 * Save.
	 * 
	 * @param user
	 *            the user
	 * @return the user
	 * @throws ZkShowcaseException 
	 */
	void save(User user) throws ZkShowcaseException;

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean delete(User user);

}
