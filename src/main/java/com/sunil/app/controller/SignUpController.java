package com.sunil.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunil.app.model.User;
import com.sunil.app.service.UserService;

@Controller
public class SignUpController {
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "register";
	}
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public String getRegister(@ModelAttribute User user, Model model) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		service.addUser(user);
		return "login";
	}
}
