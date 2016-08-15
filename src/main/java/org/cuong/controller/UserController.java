package org.cuong.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.cuong.model.Users;
import org.cuong.service.UserService;
import org.cuong.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Controller
public class UserController {
    @Autowired
    private UserService userservice;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserValidator userValidator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUser(Model model) {
        List<Users> users = userservice.findAllUsers();
        model.addAttribute("users", users);
        return "show";
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable("id") String id) {
        Users user = userservice.findById(id);
        model.addAttribute("user", user);
        return "user_detail";
    }
    
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String create(Model model) {
        createFormData(model);
        return "add_user";
    }
    
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String update(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("user", userservice.findById(id));
        return "add_user";
        
    }
    
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateAction(@ModelAttribute(value = "user") @Validated Users users, BindingResult result,
            Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("updateAction() : {}", users);
        if (result.hasErrors()) {
            return "add_user";
            
        } else {
            userservice.update(users);
            redirectAttributes.addFlashAttribute("css", "success");
            return "redirect:/users";
        }
        
    }
    
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute(value = "user") Users user) {
        userservice.createUser(user);
        createFormData(model);
        return "add_user";
    }
    
    @RequestMapping(value = "users/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "id") String id) {
        logger.debug("delete()");
        userservice.delete(id);
        return "redirect:/users";
        
    }
    
    private void createFormData(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("skills", new ArrayList<String>(Arrays.asList("Spring", "Struts")));
    }
    
}
