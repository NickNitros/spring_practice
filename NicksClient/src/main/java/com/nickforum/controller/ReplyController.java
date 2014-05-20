package com.nickforum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {

	@RequestMapping(value = "viewReply", method = RequestMethod.GET)
	public String mainLoad(Model model, HttpServletRequest request) {
		if (request.getParameter("id") == null) {
			model.addAttribute("error", "Error retrieving replies.");
			return "viewReply";
		}
		model.addAttribute("id", request.getParameter("id").toString());
		/*
		 * List<Reply> replies =
		 * replyService.getReplies(Integer.parseInt(request
		 * .getParameter("id").toString())); if (!replies.isEmpty()) {
		 * model.addAttribute("replies", replies); }
		 */
		return "viewReply";
	}
}
