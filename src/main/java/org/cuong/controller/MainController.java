//package org.cuong.controller;
//
//import org.cuong.model.Users;
//import org.cuong.service.UserService;
//import org.cuong.util.SecurityUtil;
//import org.cuong.validator.UserValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.social.connect.Connection;
//import org.springframework.social.connect.ConnectionFactoryLocator;
//import org.springframework.social.connect.UserProfile;
//import org.springframework.social.connect.UsersConnectionRepository;
//import org.springframework.social.connect.web.ProviderSignInUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//// Cần thiết để sử dụng RedirectAttributes
//@EnableWebMvc
//public class MainController {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private ConnectionFactoryLocator connectionFactoryLocator;
//
//	@Autowired
//	private UsersConnectionRepository connectionRepository;
//
//	@Autowired
//	private UserValidator userValidator;
//
//	// Set a form validator
//	@InitBinder
//	protected void initBinder(WebDataBinder dataBinder) {
//		Object target = dataBinder.getTarget();
//		if (target == null) {
//			return;
//		}
//		System.out.println("Target=" + target);
//
//		if (target.getClass() == Users.class) {
//			dataBinder.setValidator(userValidator);
//		}
//	}
//
////	 @RequestMapping(value = { "/" }, method = RequestMethod.GET)
////	 public String homePage(Model model) {
////	 try {
////	 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
////	 .getPrincipal();
////	 if (userDetails != null) {
////	 System.out.println(userDetails.getPassword());
////	 System.out.println(userDetails.getUsername());
////	 System.out.println(userDetails.isEnabled());
////	
////	 model.addAttribute("userDetails", userDetails);
////	 }
////	 } catch (Exception e) {
////	 }
////	 return "index";
////	 }
//	
////	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
////	public String welcomePage(Model model) {
////		return "login";
////	}
//
//	@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
//	public String signInPage(Model model) {
//		return "redirect:/login";
//	}
//
//	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
//	public String signupPage(WebRequest request, Model model) {
//
//		ProviderSignInUtils providerSignInUtils //
//				= new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
//		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
//		Users user = null;
//		UserProfile socialUserProfile = connection.fetchUserProfile();
//		if (connection != null) {
//			user = new Users(connection.getKey().getProviderUserId(), socialUserProfile.getEmail());
//		}
//		user.setName(socialUserProfile.getFirstName());
//		model.addAttribute("user", user);
//		return "signup";
//	}
//
//	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
//	public String signupSave(WebRequest request, //
//			Model model, //
//			@ModelAttribute("user") @Validated Users users, //
//			BindingResult result, //
//			final RedirectAttributes redirectAttributes) {
//
//		// Nếu validate có lỗi.
//		if (result.hasErrors()) {
//			return "signup";
//		}
//
//		Users registered = null;
//
//		try {
//			registered = userService.createUser(users);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			model.addAttribute("errorMessage", "Error " + ex.getMessage());
//			return "signup";
//		}
//
//		if (users.getSignInProvider() != null) {
//			ProviderSignInUtils providerSignInUtils //
//					= new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
//
//			providerSignInUtils.doPostSignUp(registered.getId(), request);
//		}
//		SecurityUtil.logInUser(registered);
//		return "redirect:/userInfo";
//	}
//
//	@RequestMapping(value = { "/userInfo" }, method = RequestMethod.GET)
//	public String userInfoPage(WebRequest request, Model model) {
//		return "userInfo";
//	}
//
//}
