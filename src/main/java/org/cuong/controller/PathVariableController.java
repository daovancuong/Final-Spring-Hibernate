package org.cuong.controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Controller
@RequestMapping("/pathVariable")
public class PathVariableController {
    
    @RequestMapping("/way_1/{name}")
    public ModelAndView getPathVariable_1(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView("pathVariable");
        modelAndView.addObject(name, name);
        return modelAndView;
    }
    
    @RequestMapping("/way_1/{name}/{address}")
    public ModelAndView getPathVariable_2(@PathVariable("name") String name, @PathVariable("address") String address) {
        ModelAndView modelAndView = new ModelAndView("pathVariable");
        modelAndView.addObject(name, name);
        modelAndView.addObject(address, address);
        return modelAndView;
    }
//    
    @RequestMapping("/way_1/{name}/{address}/{id}")
    public ModelAndView getPathVariable_3(@PathVariable HashMap<String, String> map) {
        ModelAndView modelAndView = new ModelAndView("pathVariable");
        modelAndView.addObject("name", map.get("name"));
        modelAndView.addObject("address", map.get("address"));
        modelAndView.addObject("id", map.get("id"));
        return modelAndView;
         
    }
    
}
