package com.nickforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nickforum.model.User;
import com.nickforum.service.UserService;

@Controller
public class RestUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = RestConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody User getDummyEmployee() {
		User user = new User();
		user.setId(9999l);
		user.setName("A");
		user.setEmail("B");
		return user;
	}

	@RequestMapping(value = RestConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody User getEmployee(@PathVariable("id") Long userId) {
		return userService.findUser(userId);
	}

	@RequestMapping(value = RestConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllEmployees() {
		return userService.findAll();
	}

	@RequestMapping(value = RestConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody User createEmployee(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@RequestMapping(value = RestConstants.DELETE_USER, method = RequestMethod.PUT)
	public @ResponseBody User deleteEmployee(@PathVariable("id") Long userId) {
		User user = userService.findUser(userId);
		userService.delete(userId);
		return user;
	}
}