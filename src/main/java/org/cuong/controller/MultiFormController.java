package org.cuong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cuong.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Controller
@SessionAttributes("command")
@RequestMapping("/multilform")
public class MultiFormController {
    @RequestMapping("/hello")
    public String getInitialPage(final ModelMap modelMap) {
        // put your initial command
        modelMap.addAttribute("command", new Users());
        // populate the model Map as needed
        return "Page1Form";
    }
    @ModelAttribute
    public void addCommonAtrribute(Model model) {
        model.addAttribute("title", "always show title for pages of this controller ");
    }
    
    
    @RequestMapping(params = "_step=1",method=RequestMethod.POST)
    public String processFirstStep(final @ModelAttribute("command") Users command,
                                   final Errors errors) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "firstStepView";
    }

    /**
     * Maybe you want to be provided with the _page parameter (in order to map the same method for all), as you have in
     * AbstractWizardFormController.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processPage(@RequestParam("_page") final int currentPage,
                              final @ModelAttribute("command") Users command,
                              final HttpServletResponse response) {
        // do something based on page number
//        return pageViews[currentPage];
        return null;
    }

    /**
     * The successful finish step ('_finish' request param must be present)
     */
    @RequestMapping(params = "_finish")
    public String processFinish(final @ModelAttribute("command") Users command,
                                final Errors errors,
                                final ModelMap modelMap,
                                final SessionStatus status) {
        // some stuff
        status.setComplete();
        return "successView";
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final SessionStatus status) {
        status.setComplete();
        return "canceledView";
    }
    
    
}
