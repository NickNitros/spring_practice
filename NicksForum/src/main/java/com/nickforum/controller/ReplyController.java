package com.nickforum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	
	@RequestMapping(value = "viewReply", method = RequestMethod.GET)
	public String mainLoad(Model model, HttpServletRequest request) {

		System.out.println(request.getParameter("id"));
		
		return "viewReply";
	}
}
