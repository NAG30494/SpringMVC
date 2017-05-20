package org.springmvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.dao.User;
import org.springmvc.service.UserService;

@Controller
public class UserController extends AbstractController{
	
	@Autowired
	private UserService userService;
		
	public UserService getUserService() {
		return userService;
	}

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "user/displayAllUser.htm")
	public ModelAndView displayAllUsers(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		log.info("Inside display all User.htm");
		ModelAndView view = new ModelAndView("/user/displayUsers");
		Map<Long,String> userRoles = userService.getLookup("USER_ROLE");
		Map<Long,String> genderList = userService.getLookup("GENDER");
		view.addObject("userRoles", userRoles);
		view.addObject("genders",genderList);
		view.addObject("allUsers",userService.getUserList());
		return view;
	}
	
	@RequestMapping(value = "user/updateUser.htm" )
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,User user ) throws Exception{
		ModelAndView view = new ModelAndView();
		Map<Long,String> userRoles = userService.getLookup("USER_ROLE");
		Map<Long,String> genderList = userService.getLookup("GENDER");
		view.addObject("userRoles", userRoles);
		view.addObject("genders",genderList);
		
		if(utils.getParameter(request, "option").equalsIgnoreCase("save")){
			view.setViewName("/user/editUser");
			if(userService.saveUser(user)){
				view.addObject("SuccessMsg", "generic.update.Success~look.lookup");
			}else{
				view.addObject("ErrorMsg","generic.update.failure");
			}
			log.info(user);
		}else{
			view.setViewName("/user/displayUsers");
			if(userService.removeUser(user)){
				view.addObject("SuccessMsg", "generic.delete.Success~user.user");
			}else{
				view.addObject("ErrorMsg","generic.delete.failure~user.user");
			}
		}
		view.addObject("User",user);
		return view;
		
	}
	
	@RequestMapping(value = "/user/editUser.htm")
	public ModelAndView editUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		long userId = utils.getLongParameter(request,"userId");
		log.info(" Edit User "+userId);
		User user = null;
		if(userId==0){
			user = new User();
		}else{
			user = userService.getUserById(userId);
		}
		System.out.println(user.getUserDescription());
		Map<Long,String> userRoles = userService.getLookup("USER_ROLE");
		Map<Long,String> genderList = userService.getLookup("GENDER");
		ModelAndView view = new ModelAndView("/user/editUser");
		log.info("userRoles "+userRoles.toString());
		log.info("genderList "+genderList.toString());
		view.addObject("userRoles", userRoles);
		view.addObject("genders",genderList);
		view.addObject("User",user);
		return view;
	}
	
	/*
	@RequestMapping(value = "/addUser.htm")
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Lookup> userRoles = userService.getLookup("USER_ROLE");
		List<Lookup> genderList = userService.getLookup("GENDER");
		ModelAndView view = new ModelAndView("editUser");
		view.addObject("userRoles", userRoles);
		view.addObject("genders",genderList);
		view.addObject("User",new User());
		return view;
	}
	
	@RequestMapping(value = "user/changePassword.htm")
		public ModelAndView chageUserPassword(long id){
			log.warn(" Calling Reset Password"+id);
			ModelAndView forwardPage = new ModelAndView("resetPassword");
			forwardPage.addObject("userId",id);
			User user = userService.getUserById(id);
			return forwardPage;
		}
	
	@RequestMapping(value = "user/resetPassword.htm" , method = RequestMethod.POST)
	public ModelAndView resetPassword(HttpServletRequest request,HttpServletResponse response) throws Exception{
		long id=utils.getLongParameter(request, "userId");
		String currentPassword=utils.getParameter(request,"currentPassword");
		String newPassword=utils.getParameter(request,"newPassword");;
		String repeatPassword=utils.getParameter(request,"repeatPassword");;
		log.warn("Current Password "+currentPassword+" new Password : "+newPassword+" Repeat Password : "+repeatPassword);
		ModelAndView forwardPage = new ModelAndView("resetPassword");
		forwardPage.addObject("id",id);
		Map<String,String> result = userService.changePassword( id,  currentPassword, newPassword,repeatPassword);
		for(String str:result.keySet()){
			forwardPage.addObject(str, result.get(str));
		}
		return forwardPage;
	}*/
	
	
	
}