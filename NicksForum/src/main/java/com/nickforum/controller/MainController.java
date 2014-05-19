package com.nickforum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nickforum.model.Topic;
import com.nickforum.model.User;
import com.nickforum.service.TopicService;

@Controller
public class MainController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String mainLoad(Model model, HttpSession session) {
		try {
			User current = (User) session.getAttribute("user");
			System.out.println("Logged: " + current.getEmail());
		} catch (Exception e) {
			model.addAttribute("invalid", "You are not logged in.");
			return "redirect:login.html";
		}

		List<Topic> topics = topicService.getAllTopics();

		model.addAttribute("topics", topics);

		return "main";
	}
}
