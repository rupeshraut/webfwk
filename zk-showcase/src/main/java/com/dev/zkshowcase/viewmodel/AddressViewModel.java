package com.dev.zkshowcase.viewmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import com.dev.zkshowcase.exception.ZkShowcaseException;
import com.dev.zkshowcase.model.User;
import com.dev.zkshowcase.service.UserService;

/**
 * The Class AddressViewModel.
 * @author Rupesh
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AddressViewModel {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(AddressViewModel.class);

	/** The address win. */
	@Wire("#addressWin")
	private Window addressWin;

	/** The session. */
	@WireVariable
	private Session session;

	/** The user service. */
	@WireVariable
	private UserService userService;

	/** The user. */
	private User user;

	/**
	 * After compose.
	 * 
	 * @param view
	 *            the view
	 */
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	/**
	 * Inits the.
	 */
	@Init
	public void init() {
		this.user = (User) session.getAttribute("SESSION_USER");
		LOGGER.info(this.user);
		LOGGER.info(this.user.getAddress());
	}// init()

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Save.
	 * 
	 * @throws ZkShowcaseException
	 */
	@Command
	public void save() throws ZkShowcaseException {
		LOGGER.info("saving user's address");
		userService.save(getUser());
		addressWin.detach();
	}

}
