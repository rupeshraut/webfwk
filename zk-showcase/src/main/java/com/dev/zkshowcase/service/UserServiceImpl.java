package com.dev.zkshowcase.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.zkshowcase.dao.UserDAO;
import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.viewmodel.User;

/**
 * The Class UserServiceImpl.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/** The user DAO. */
	private final UserDAO userDAO;

	/**
	 * Instantiates a new user service impl.
	 * 
	 * @param userDAO
	 *            the user dao
	 */
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	/**
	 * List users.
	 * 
	 * @return the list
	 * @see com.dev.zkshowcase.service.UserService#listUsers()
	 */
	@Override
	public Collection<User> listUsers() {
		return userDAO.listUsers();
	}

	/**
	 * Save.
	 * 
	 * @param user
	 *            the user
	 * @return the user
	 * @throws ZkShowcaseException 
	 * @see com.dev.zkshowcase.service.UserService#save(com.dev.zkshowcase.viewmodel
	 *      .User)
	 */
	@Override
	public void save(final User user) throws ZkShowcaseException {
		userDAO.save(user);
	}

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 * @see com.dev.zkshowcase.service.UserService#delete(com.dev.zkshowcase.viewmodel
	 *      .User)
	 */
	@Override
	public boolean delete(final User user) {
		return userDAO.delete(user);
	}

}
