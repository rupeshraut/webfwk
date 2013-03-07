package com.dev.zkshowcase.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev.zkshowcase.model.User;

/**
 * The Enum DataStore.
 */
public enum DataStore {

	/** The instance. */
	INSTANCE;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(DataStore.class);

	/** The Constant USER_MAP. */
	private static final ConcurrentMap<String, User> USER_MAP = new ConcurrentHashMap<>(1);

	/**
	 * Adds the.
	 * 
	 * @param user
	 *            the user
	 */
	public void add(final User user) {

		if (USER_MAP.containsKey(user.getId())) {
			LOGGER.info("replacing an existing user to data store {}", user.toString());
			USER_MAP.replace(user.getId(), user);
		} else {
			LOGGER.info("adding new user to data store {}", user.toString());
			USER_MAP.put(user.getId(), user);
		}// if

		LOGGER.info("user data store size {}", USER_MAP.size());
	}// add()

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public boolean delete(final User user) {
		return (USER_MAP.remove(user.getId()) != null);
	}

	/**
	 * List all.
	 * 
	 * @return the collection
	 */
	public Collection<User> listAll() {
		return new ArrayList<User>(USER_MAP.values());
	}

}
