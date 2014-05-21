package com.nickforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nickforum.model.Reply;
import com.nickforum.service.ReplyService;

@Controller
public class RestReplyController {

	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = RestConstants.DUMMY_REPLY, method = RequestMethod.GET)
	public @ResponseBody Reply getDummyReply() {
		Reply reply = new Reply();
		reply.setId(9999l);
		reply.setText("randomTopic");
		return reply;
	}

	@RequestMapping(value = RestConstants.GET_REPLY, method = RequestMethod.GET)
	public @ResponseBody List<Reply> getReply(@PathVariable("id") Long topicId) {
		return replyService.getReplies(topicId);
	}

	@RequestMapping(value = RestConstants.GET_ALL_REPLY, method = RequestMethod.GET)
	public @ResponseBody List<Reply> getAllReplies() {
		// return replyService.findAll();
		return null;
	}

	@RequestMapping(value = RestConstants.CREATE_REPLY, method = RequestMethod.POST)
	public @ResponseBody Reply createReply(@RequestBody Reply reply) {
		// replyService.save(reply);
		// return reply;
		return null;
	}

	@RequestMapping(value = RestConstants.DELETE_REPLY, method = RequestMethod.PUT)
	public @ResponseBody Reply deleteReply(@PathVariable("id") Long replyId) {
		// Reply reply = replyService.findTopic(replyId);
		// replyService.delete(replyId);
		// return reply;
		return null;
	}
}
