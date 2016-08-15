package org.cuong.controller;

import javax.servlet.http.HttpSession;

import org.cuong.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = { "user" }, types = { Users.class })
public class MultipleSubmit {
    
    @ModelAttribute("user")
    public Users addAttributes() {
        return new Users("asdf", "asdf");
    }
    
    @RequestMapping(value = "infor")
    public String country() {
        return "start";
    }
    
    @RequestMapping("/multiplesubmit")
    public String showForm(Model model) {
        return "multiplesubmitbuttons";
        
    }
    
    @RequestMapping(value = "/processForm", params = "action1", method = RequestMethod.POST)
    public String action1(HttpSession session, @CookieValue("JSESSIONID") String cookie,Model model) {
        System.out.println("action 1");
        System.out.println("session-pet:" + ((Users) session.getAttribute("user")).getId());
        System.out.println("JSESSIONID:"+ cookie);
        return "multiplesubmitbuttons";
    }
    
    @RequestMapping(value = "/processForm", params = "action2", method = RequestMethod.POST)
    public String action2(HttpSession session) {
        System.out.println("action 2");
        return "multiplesubmitbuttons";
    }
    
}
