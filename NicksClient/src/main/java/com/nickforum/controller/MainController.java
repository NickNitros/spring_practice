package com.nickforum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nickforum.model.Topic;
import com.nickforum.model.User;

@Controller
public class MainController {

	RestTemplate restTemp = new RestTemplate();

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String mainLoad(Model model, HttpSession session) {
		System.out.println("Running main.");
		try {
			User current = (User) session.getAttribute("user");
			System.out.println("Logged: " + current.getEmail());
		} catch (Exception e) {
			model.addAttribute("invalid", "You are not logged in.");
			return "redirect:login.html";
		}

		ResponseEntity<Topic[]> topicsList = restTemp.getForEntity(
				"http://localhost:8080/NicksForum/rest/topics", Topic[].class);
		System.out.println(topicsList);
		Topic[] topics = topicsList.getBody();

		if (topics.length > 0) {
			model.addAttribute("topics", topics);
		}

		return "main";
	}
}
