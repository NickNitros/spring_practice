package com.nickforum.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nickforum.model.Topic;

@Controller
public class AddController {

	RestTemplate restTemp = new RestTemplate();

	@RequestMapping(value = "/addTopic", method = RequestMethod.GET)
	public String getRegister(@ModelAttribute("topic") Topic topic) {

		return "addTopic";
	}

	@RequestMapping(value = "addTopic", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("topic") Topic topic,
			BindingResult result) {

		System.out.println("result has errors: " + result.hasErrors());

		if (result.hasErrors()) {
			return "addTopic";
		} else {
			System.out.println("Topic saved: " + topic.getTitle() + " "
					+ topic.getDescription());
			restTemp.postForEntity(
					"http://localhost:8080/NicksForum/rest/topic/create",
					topic, Topic.class);
			return "redirect:main.html";
		}
	}

}
