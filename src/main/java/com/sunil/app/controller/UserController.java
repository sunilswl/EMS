package com.sunil.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sunil.app.model.User;
import com.sunil.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public String getUsers(HttpSession session, Model model) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		model.addAttribute("userlist",service.getAllUser());
		return "users";
	}
	@GetMapping("/update")
	public String updateUser(@RequestParam int id, HttpSession session, Model model) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		model.addAttribute("umodel",service.getById(id));
		return "updateuser";
	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute User user, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "login";
		}
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		service.updateUser(user);
		return "redirect:users";
	}
	
}
