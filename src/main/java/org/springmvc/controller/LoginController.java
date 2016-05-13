package org.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.dao.views.ViewUserPassword;
import org.springmvc.service.LoginService;

@Controller
public class LoginController extends AbstractController {

	@Autowired
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "/loginAction.htm")
	public ModelAndView controllerlogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = utils.getParameter(request, "j_username");
		log.warn("User Name " + userName);
		String userPassword = utils.getPasswordEncryption(utils.getParameter(request, "j_password"));
		ModelAndView modelView = null;

		log.warn("User Password " + userPassword);
		System.out.println("Calling login controller");
		ViewUserPassword viewUserPassword = loginService.AuthenticateUser(userName, userPassword,
				request.getSession().getId(), request.getRemoteAddr());
		if (viewUserPassword != null && !viewUserPassword.getIsUserLocked()
				&& viewUserPassword.getPasswordAttempt() == 0) {
			modelView = new ModelAndView("/common/tc");
			request.getSession().setAttribute("userSession", viewUserPassword);
			log.warn("loggin Success");
		} else if (viewUserPassword != null && viewUserPassword.getIsUserLocked()) {
			log.warn("loggin Failure");
			modelView = new ModelAndView("/login");
			modelView.addObject("j_username", utils.getParameter(request, "j_username"));
			modelView.addObject("j_password", utils.getParameter(request, "j_password"));
			modelView.addObject("ErrorMsg", "user.lock.error");
		} else {
			log.warn("loggin Failure");
			modelView = new ModelAndView("/login");
			modelView.addObject("j_username", utils.getParameter(request, "j_username"));
			modelView.addObject("j_password", utils.getParameter(request, "j_password"));
			modelView.addObject("ErrorMsg", "user.login.failure");
		}
		return modelView;
	}

}
