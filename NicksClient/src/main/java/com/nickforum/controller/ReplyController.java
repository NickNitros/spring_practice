package com.nickforum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nickforum.model.Reply;

@Controller
public class ReplyController {

	RestTemplate restTemp = new RestTemplate();

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

		ResponseEntity<Reply[]> replyList = restTemp.getForEntity(
				"http://localhost:8080/NicksForum/rest/reply/"
						+ request.getParameter("id").toString(), Reply[].class);
		Reply[] replies = replyList.getBody();
		if (replies.length > 0) {
			model.addAttribute("replies", replies);
		}
		return "viewReply";
	}
}
