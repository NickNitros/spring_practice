package com.nickforum.service;

import java.util.List;

import com.nickforum.model.Topic;

public interface TopicService {

	List<Topic> findAll();

	Topic findTopic(Long id);

	void save(Topic t);

	void delete(Long id);
}
