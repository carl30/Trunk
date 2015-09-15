package com.carlcorp.controller;

import com.carlcorp.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {

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