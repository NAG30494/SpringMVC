package org.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController extends AbstractController {
	
	@RequestMapping(value={"/","/home"} ,method = RequestMethod.GET)
	public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView forwardPage = null;
		log.warn(" Calling redirectLogin :" );
		if(request.getSession()==null){
		forwardPage = new ModelAndView("/login");
		}else{
			forwardPage = new ModelAndView("/common/tc");
		}
		return forwardPage;

	}


	
}
