package com.nickforum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jetty.jndi.local.localContextRoot;
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
public class TestController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = RestConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody User getDummyEmployee() {
		User emp = new User();
		emp.setId(9999l);
		emp.setName("A");
		emp.setEmail("B");
		return emp;
	}

	@RequestMapping(value = RestConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody User getEmployee(@PathVariable("id") Long empId) {

		return userService.findUser(empId);
	}

	@RequestMapping(value = RestConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllEmployees() {
		return userService.findAll();
	}

	@RequestMapping(value = RestConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody User createEmployee(@RequestBody User emp) {
		//empData.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = RestConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody User deleteEmployee(@PathVariable("id") Long empId) {
		User emp = userService.findUser(empId);
		//empData.remove(empId);
		return emp;
	}
}
