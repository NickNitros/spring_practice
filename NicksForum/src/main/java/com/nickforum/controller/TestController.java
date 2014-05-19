package com.nickforum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nickforum.model.User;

@Controller
public class TestController {

	// Map to store employees, ideally we should use database
	Map<Long, User> empData = new HashMap<Long, User>();

	@RequestMapping(value = RestConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody User getDummyEmployee() {
		User emp = new User();
		emp.setId(9999l);
		emp.setName("A");
		emp.setEmail("B");
		empData.put(9999l, emp);
		return emp;
	}

	@RequestMapping(value = RestConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody User getEmployee(@PathVariable("id") int empId) {

		return empData.get(empId);
	}

	@RequestMapping(value = RestConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllEmployees() {
		List<User> emps = new ArrayList<User>();
		Set<Long> empIdKeys = empData.keySet();
		for (Long i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = RestConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody User createEmployee(@RequestBody User emp) {
		empData.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = RestConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody User deleteEmployee(@PathVariable("id") int empId) {
		User emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
}
