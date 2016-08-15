package org.cuong.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
@Controller
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

//	@RequestMapping("/login")
//	public ModelAndView helloPage(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout) {
//		ModelAndView modelAndView = new ModelAndView("login");
//		if (error != null) {
//			modelAndView.addObject("error", error);
//			return modelAndView;
//
//		}
//		if (logout != null) {
//			modelAndView.addObject(logout, logout);
//			return modelAndView;
//
//		}
//		return modelAndView;
//
//	}

//	@RequestMapping("/aaa")
//	public String xxxpage(Model model, Principal principal) {
//		model.addAttribute("message", "username:" + principal.getName() + "- password:" + principal.toString());
//		return "xxx";
//
//	}
//
//	@RequestMapping("/bbb")
//	public String logout(Model model) {
//		return "home";
//
//	}
//	//
//	 @RequestMapping("/**") // * for one slash  ** for every url  
//	 public String home(Model model) {
//	 return "home";
//	 }

}
