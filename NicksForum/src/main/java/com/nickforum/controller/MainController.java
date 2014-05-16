package com.nickforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nickforum.model.Topic;
import com.nickforum.service.TopicService;

@Controller
public class MainController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String mainLoad(Model model) {

		List<Topic> topics = topicService.getAllTopics();

		model.addAttribute("topics", topics);

		return "main";
	}
}
