package org.cuong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.cuong.model.UserNameEditor;
import org.cuong.model.Users;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
@Controller
@RequestMapping("/handleform")
public class HandelFormController {
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // webDataBinder.setDisallowedFields(disallowedFields);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy*mm*dd");
        webDataBinder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, false));
        webDataBinder.registerCustomEditor(String.class, "name", new UserNameEditor());
        
    }
    
    @RequestMapping("")
    public ModelAndView prepareForm() {
        ModelAndView modelAndView = new ModelAndView("handle_form_addmission_form");
        return modelAndView;
        
    }
    
    @ModelAttribute
    public void createCommonTitle(Model model) {
        model.addAttribute("title", "title defaut for this controler");
        
    }
    
    // @RequestMapping(value = "/doform", method = RequestMethod.POST) // way 1
    // public ModelAndView doForm(@RequestParam(value = "firstname",
    // defaultValue = "daovancuong") String firstName,
    // @RequestParam("lastname") String lastName) {
    // ModelAndView modelAndView = new
    // ModelAndView("handle_form_addmission_form_success");
    // modelAndView.addObject("message", firstName + ":" + lastName);
    // return modelAndView;
    //
    // }
    // @RequestMapping(value = "/doform", method = RequestMethod.POST)//way 2
    // public ModelAndView doForm(@RequestParam HashMap<String, String> map) {
    // ModelAndView modelAndView = new
    // ModelAndView("handle_form_addmission_form_success");
    // modelAndView.addObject("message", map.get("firstname") + ":" +
    // map.get("lastname"));
    // return modelAndView;
    //
    // }
    @RequestMapping(value = "/doform", method = RequestMethod.POST) // way_3
    public ModelAndView doform(@Valid @ModelAttribute("user") Users user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("handle_form_addmission_form");
        }
        ModelAndView modelAndView = new ModelAndView("handle_form_addmission_form_success");
        
        modelAndView.addObject("message", user.toString());
        
        return modelAndView;
        
    }
    
    @RequestMapping("theme_setting")
    public String themeSetting() {
        throw new NullPointerException();
//        return "theme_setting";//chua chay duoc
        
    }
    
//    @ExceptionHandler(value = NullPointerException.class)
//    public String handleNullPointerEX(Exception exception) {
//        System.out.println(exception.toString());
//        return "nullpointer_exception";
//        
//    }
    
}
