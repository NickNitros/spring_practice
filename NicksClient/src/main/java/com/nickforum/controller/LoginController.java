package com.nickforum.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.nickforum.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	RestTemplate restTemp = new RestTemplate();

	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) {

		System.out.println("result has errors: " + result.hasErrors());

		System.out.println("User got: \"" + user.getEmail() + "\"");

		if (result.hasErrors()) {
			return "login";
		} else {

			try {
				String json = mapper.writeValueAsString(user);
				
				ResponseEntity<String> authString = restTemp.postForEntity(
						"http://localhost:8080/NicksForum/rest/user/auth", json,
						String.class);
				
				System.out.println("Back here: " + authString.getBody());
				
			} catch (Exception e) {
				e.printStackTrace();
				return "login";
			}

			/*
			 * ResponseEntity<User> userCheck = restTemp.postForEntity(
			 * "http://localhost:8080/NicksForum/rest/user/email", user,
			 * User.class); // check user exists if (userCheck.getBody() ==
			 * null) { model.addAttribute("invalid", "Invalid login details.");
			 * } else { return "redirect:main.html"; }
			 */
		}

		return "login";
	}
}
