package com.dev.zkshowcase.dao;

import java.util.Collection;

import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO {

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
