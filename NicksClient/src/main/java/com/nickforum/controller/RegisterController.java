package com.nickforum.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nickforum.model.User;

@Controller
public class RegisterController {

	RestTemplate restTemp = new RestTemplate();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(@ModelAttribute("user") User user) {

		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) {

		System.out.println("result has errors: " + result.hasErrors());

		if (result.hasErrors()) {
			return "register";
		} /*
		 * else { if (!userService.checkExists(user.getEmail())) {
		 * System.out.println("User saved: " + user.getName() + " " +
		 * user.getEmail()); userService.save(user); return
		 * "redirect:login.html"; } else { model.addAttribute("invalid",
		 * "That email already exists!"); return "register"; } }
		 */
		try {
			restTemp.postForEntity(
					"http://localhost:8080/NicksForum/rest/user/create", user,
					User.class);
		} catch (Exception e) {
			model.addAttribute("invalid", e.getMessage());
		}

		return "register";
	}
}
