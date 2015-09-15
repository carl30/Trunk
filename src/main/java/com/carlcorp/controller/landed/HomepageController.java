package com.carlcorp.controller.landed;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiajunhe on 2015/9/15.
 */
@Controller
@RequestMapping("/landed/")
public class HomepageController {

    private static Logger logger = LogManager.getLogger(HomepageController.class.getName());

    private static String LANDED_ROOT = "/landed/";
    private static String LANDED_HOMEPAGE = "index";
    private static String LANDED_LEFT_SIDEBAR = "left-sidebar";
    private static String LANDED_RIGHT_SIDEBAR = "right-sidebar";
    private static String LANDED_NO_SIDEBAR = "no-sidebar";
    private static String LANDED_ELEMENTS = "elements";


    @RequestMapping(value = "home")
    public ModelAndView homepage (){
        ModelAndView modelAndView = new ModelAndView(LANDED_ROOT + LANDED_HOMEPAGE);

        return modelAndView;
    }

    @RequestMapping("{pageName}")
    public ModelAndView getPageAcPageName(@PathVariable("pageName") String pageName){
        ModelAndView modelAndView = new ModelAndView(LANDED_ROOT + pageName);
        logger.info("Client viewing: " + pageName);
        return modelAndView;
    }

}
