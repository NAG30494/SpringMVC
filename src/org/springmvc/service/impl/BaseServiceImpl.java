package org.springmvc.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.dao.User;
import org.springmvc.dao.views.ViewUserPassword;
import org.springmvc.service.BaseService;
import org.springmvc.web.utils.AppUtils;

public abstract class BaseServiceImpl implements BaseService{
	protected final Log log = LogFactory.getLog(getClass());

	protected ViewUserPassword viewUserPassword;

	@Autowired
	protected AppUtils utils;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AppUtils getUtils() {
		return utils;
	}

	public void setUtils(AppUtils utils) {
		this.utils = utils;
	}

	public ViewUserPassword getViewUserPassword() {
		return viewUserPassword;
	}

	public void setViewUserPassword(ViewUserPassword viewUserPassword) {
		this.viewUserPassword = viewUserPassword;
	}

}
