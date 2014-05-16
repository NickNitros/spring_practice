package com.nickforum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickforum.model.Reply;
import com.nickforum.repository.ReplyRepository;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;

	public List<Reply> getReplies(int topicID) {
		return replyRepository.findAll();
	}

}
