package org.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.dao.Lookup;
import org.springmvc.dao.views.ViewUserPassword;
import org.springmvc.service.LookupService;

@Controller
public class LookupController extends AbstractController{


	@Autowired
	private LookupService lookupService;


	@RequestMapping(value = "lookup/lookup.htm")
	public ModelAndView showLookup(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ModelAndView view = new ModelAndView("/lookup/showLookup");
		view.addObject("allLookups", lookupService.getLookupList());
		return view;
	}
	
	@RequestMapping(value = "lookup/editLookup.htm")
	public ModelAndView addLookup(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		log.error(" Lookup Id "+request.getParameter("id"));
		long lookupID = utils.getLongParameter(request, "id");
		Lookup lookup = new Lookup();
		if(lookupID>0){
			lookup =lookupService.getLookupById(lookupID);
		}
		ModelAndView view = new ModelAndView("/lookup/editLookup");
		view.addObject("Lookup",lookup);
		return view;
	}
	
	@RequestMapping(value = "lookup/saveLookup.htm")
	public ModelAndView addLookup(HttpServletRequest request,Lookup lookup) {
		log.info("inside lookup/saveLookup.htm");
		ModelAndView view = null;
		ViewUserPassword viewUserPassword =(ViewUserPassword) request.getSession().getAttribute("userSession");
		log.info(" Option "+utils.getParameter(request, "option"));
		if(utils.getParameter(request, "option").equalsIgnoreCase("save")){
			view =new ModelAndView("/lookup/editLookup");
			if(lookupService.saveLookup(lookup)){
				//view.addObject("SuccessMsg", "generic.update.Success~look.lookup");
				view.addObject("ErrorMsg","generic.update.failure~look.lookup");
			}else{
				view.addObject("ErrorMsg","generic.update.failure~look.lookup");
			}
			log.info(lookup);
		}else{
			view =new ModelAndView("/lookup/showLookup");
			if(lookupService.remove(lookup)){
				view.addObject("SuccessMsg", "generic.delete.Success~look.lookup");
			}else{
				view.addObject("ErrorMsg","generic.delete.failure~look.lookup");
			}
		}
		view.addObject("Lookup",lookup);
		return view;
	}
}
