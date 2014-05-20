package com.nickforum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickforum.model.Topic;
import com.nickforum.repository.TopicRepository;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> findAll() {
		return topicRepository.findAll();
	}

	public void save(Topic t) {
		topicRepository.save(t);
	}

	public void delete(Long id) {
		topicRepository.delete(id);
	}

	public Topic findTopic(Long id) {
		return topicRepository.findOne(id);
	}

}
