package org.springmvc.service;

import org.springmvc.dao.views.ViewUserPassword;

public interface LoginService {
	public ViewUserPassword AuthenticateUser(String userName,String password,String JSessionID, String ipAddress);
}
