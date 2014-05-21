package com.nickforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nickforum.model.Topic;
import com.nickforum.service.TopicService;

@Controller
public class RestTopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = RestConstants.DUMMY_TOPIC, method = RequestMethod.GET)
	public @ResponseBody Topic getDummyTopic() {
		Topic topic = new Topic();
		topic.setId(9999l);
		topic.setTitle("DummyTitle");
		topic.setDescription("DummyDescrip");
		return topic;
	}

	@RequestMapping(value = RestConstants.GET_TOPIC, method = RequestMethod.GET)
	public @ResponseBody Topic getTopic(@PathVariable("id") Long topicId) {
		return topicService.findTopic(topicId);
	}

	@RequestMapping(value = RestConstants.GET_ALL_TOPIC, method = RequestMethod.GET)
	public @ResponseBody List<Topic> getAllTopics() {
		return topicService.findAll();
	}

	@RequestMapping(value = RestConstants.CREATE_TOPIC, method = RequestMethod.POST)
	public @ResponseBody Topic createTopic(@RequestBody Topic topic) {
		topicService.save(topic);
		return topic;
	}

	@RequestMapping(value = RestConstants.DELETE_TOPIC, method = RequestMethod.PUT)
	public @ResponseBody Topic deleteTopic(@PathVariable("id") Long topicId) {
		Topic topic = topicService.findTopic(topicId);
		topicService.delete(topicId);
		return topic;
	}
}
