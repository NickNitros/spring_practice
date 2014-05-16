package com.nickforum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nickforum.model.Reply;
import com.nickforum.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = "viewReply", method = RequestMethod.GET)
	public String mainLoad(Model model, HttpServletRequest request) {
		if(request.getParameter("id") == null) {
			model.addAttribute("error", "Error retrieving replies.");
			return "viewReply";
		}
		model.addAttribute("id", request.getParameter("id").toString());
		List<Reply> replies = replyService.getReplies(Integer.parseInt(request
				.getParameter("id").toString()));
		if (!replies.isEmpty()) {
			model.addAttribute("replies", replies);
		}
		return "viewReply";
	}
}
