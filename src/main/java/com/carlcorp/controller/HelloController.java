package com.carlcorp.controller;

import com.carlcorp.model.User;
import com.carlcorp.service.useractivities.UserLoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	private static Logger logger = LogManager.getLogger(HelloController.class.getName());

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private UserLoginService userLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {

		userLoginService.verifyCurrentUser(new User(1, "carl"));

		return new ModelAndView("hello");
	}

	@RequestMapping(value = "testJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	List<User> testJson (){
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User userT = new User(i, "name"+i);
			userList.add(userT);
		}
		return userList;
	}

}