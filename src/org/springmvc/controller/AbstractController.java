package org.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.web.utils.AppUtils;

public class AbstractController {
	
	protected Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	protected AppUtils utils;

	public AppUtils getUtils() {
		return utils;
	}

	public void setUtils(AppUtils utils) {
		this.utils = utils;
	}
}
