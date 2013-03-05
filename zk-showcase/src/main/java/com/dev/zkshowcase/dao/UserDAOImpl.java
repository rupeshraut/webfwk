package com.dev.zkshowcase.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.dev.zkshowcase.data.DataStore;
import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.viewmodel.User;

/**
 * The Class UserDAOImpl.
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	/**
	 * @return the collection
	 * @see com.dev.zkshowcase.dao.UserDAO#listUsers()
	 */
	@Override
	public Collection<User> listUsers() {
		return DataStore.INSTANCE.listAll();
	}

	/**
	 * @param user
	 *            the user
	 * @return the user
	 * @throws ZkShowcaseException 
	 * @see com.dev.zkshowcase.dao.UserDAO#save(com.dev.zkshowcase.viewmodel.User)
	 */
	@Override
	public void save(User user) throws ZkShowcaseException {
		DataStore.INSTANCE.add(user);
	}

	/**
	 * @param user
	 *            the user
	 * @return true, if successful
	 * @see com.dev.zkshowcase.dao.UserDAO#delete(com.dev.zkshowcase.viewmodel.User)
	 */
	@Override
	public boolean delete(User user) {
		return DataStore.INSTANCE.delete(user);
	}

}
