package com.nttdata.controller;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.model.User;
import com.nttdata.model.UserInfo;
import com.nttdata.service.ServiceUser;


public class Controller {
	
	@Autowired
	private ServiceUser userservice;

	public void setUserService(ServiceUser UserService) {
		this.userservice = UserService;
	}
	
	public ServiceUser getUserService() {
		return userservice;
	}
	
	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("UserCredential", new UserInfo());
		return "login";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("User", new User());
		return "register";
	}

	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("User") User User,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getUserService().registerUser(User);
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("User", User);
		return modelAndView;
	}
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("UserCredential") UserInfo UserCredential,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		User User = getUserService().validateUserCredential(UserCredential.getEmail(), UserCredential.getPassword());
		if(User!= null){
			modelAndView.addObject("User", User);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
	
	@ModelAttribute
	public void headerMessage(Model model){
		model.addAttribute("headerMessage", "Welcome!!!!!!!!!!");
		
		List<String> CousrseList = new ArrayList<>();
		CousrseList.add("Java");
		CousrseList.add("Web Technology");
		
		List<String> LocationList = new ArrayList<>();
		LocationList.add("Blr");
		LocationList.add("Coimbatore");
		
		model.addAttribute("CourseList", CousrseList);
		model.addAttribute("LocationList", LocationList);
	}
}

