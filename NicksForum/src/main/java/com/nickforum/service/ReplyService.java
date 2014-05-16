package com.nickforum.service;

import java.util.List;

import com.nickforum.model.Reply;

public interface ReplyService {

	List<Reply> getReplies(int topicID);

}
