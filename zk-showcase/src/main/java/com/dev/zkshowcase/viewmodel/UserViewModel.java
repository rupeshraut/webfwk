package com.dev.zkshowcase.viewmodel;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.spring.SpringUtil;

import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.service.UserService;

/**
 * The Class UserViewModel.
 */
public class UserViewModel {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(UserViewModel.class);

	/** The user. */
	private User user;

	/** The selected user. */
	private User selectedUser;

	/** The user service. */
	private UserService userService;

	/** The users. */
	private Collection<User> userList;

	/** The Constant ADD_USER. */
	private static final String ADD_USER = "Add User";

	/** The Constant EDIT_USER. */
	private static final String EDIT_USER = "Edit User";

	/** The label. */
	private String label = ADD_USER;

	/**
	 * Instantiates a new user view model.
	 */
	public UserViewModel() {
	}

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Initialize.
	 */
	@Init
	public void initialize() {
		user = new User();
		userService = (UserService) SpringUtil.getBean("userService");
		userList = userService.listUsers();
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Gets the selected user.
	 * 
	 * @return the selected user
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * Sets the selected user.
	 * 
	 * @param selectedUser
	 *            the new selected user
	 */
	@NotifyChange({ "fullName", "user", "label" })
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
		user = selectedUser;
		setLabel(EDIT_USER);
	}

	/**
	 * Gets the users.
	 * 
	 * @return the users
	 */
	public Collection<User> getUserList() {
		userList = userService.listUsers();
		LOGGER.info("user collection size {}", userList.size());
		return userList;
	}

	/**
	 * Gets the full name.
	 * 
	 * @return the full name
	 */
	public String getFullName() {
		return String.format("%s %s", StringUtils.defaultIfEmpty(user.getFirstName(), ""), StringUtils.defaultIfEmpty(user.getLastName(), ""));
	}

	/**
	 * Save user.
	 * 
	 * @throws ZkShowcaseException
	 *             the zk showcase exception
	 */
	@Command
	@NotifyChange({ "user", "fullName", "userList" })
	public void saveUser() throws ZkShowcaseException {
		LOGGER.info("{} {}", user.getFirstName(), user.getLastName());
		userService.save(user);
		if (!EDIT_USER.equals(label)) {
			user = new User();
		}// if

	}

	/**
	 * Reset.
	 */
	@Command
	@NotifyChange({ "user", "fullName", "label" })
	public void reset() {
		user = new User();
		setLabel(ADD_USER);
	}

	/**
	 * Delete user.
	 * 
	 * @param user
	 *            the user
	 */
	@NotifyChange({ "userList" })
	@Command
	public void deleteUser(@BindingParam("user") User user) {
		userService.delete(user);
		if (EDIT_USER.equals(label)) {
			reset();
		}
	}

}
