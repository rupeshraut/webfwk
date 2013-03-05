package com.dev.zkshowcase.data;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.viewmodel.User;

/**
 * The Enum DataStore.
 */
public enum DataStore {

	/** The instance. */
	INSTANCE;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(DataStore.class);

	/** The Constant USERS. */
	private static final Collection<User> USERS = new CopyOnWriteArraySet<>();

	/**
	 * Adds the.
	 * 
	 * @param user
	 *            the user
	 * @throws ZkShowcaseException
	 *             the zk showcase exception
	 */
	public void add(final User user) throws ZkShowcaseException {
		LOGGER.info("adding user to data store {}", user.toString());
//		if (USERS.contains(user)) {
//			throw new ZkShowcaseException(String.format("user already exists - %s", user.toString()));
//		}// if
		USERS.add(user);
		LOGGER.info("user data store size {}", USERS.size());
	}// add()

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean delete(final User user) {
		return USERS.remove(user);
	}

	/**
	 * List all.
	 * 
	 * @return the collection
	 */
	public Collection<User> listAll() {
		return USERS;
	}

}
