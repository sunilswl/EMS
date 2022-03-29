package com.sunil.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SidebarController {
	@GetMapping("/dashboard")
	public String getHome(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "index";
	}
	@GetMapping("/profile")
	public String getProfile(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "profile";
	}
	

	@GetMapping("/faq")
	public String getFaq(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "others/faq";
	}

	@GetMapping("/contactus")
	public String contactUs(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "contact-us";
	}

	@GetMapping("/contact")
	public String contact(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "contacts";
	}
	@GetMapping("/mail")
	public String mail(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		return "others/compose";
	}
	
}
