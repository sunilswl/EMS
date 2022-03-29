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
public class LoginController {
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String getSignIn(@ModelAttribute User user, HttpSession session, Model model) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = service.loginUser(user.getEmail(), user.getPassword());
		
		Long nouser=service.countUser();

		if (usr != null) {
			session.setAttribute("user", usr);
			session.setAttribute("NoUser", nouser);
			//model.addAttribute("NoUser", nouser);
//			session.setMaxInactiveInterval(300);
			return "redirect:/dashboard";
		} else {
			model.addAttribute("message", "Username password not match!");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@GetMapping("/forgot")
	public String forgot() {
		return "forgot-password";
	}

	@PostMapping("/recoverpsw")
	public String recover(@RequestParam("email") String email, Model rmodel) {
		if (service.getByEmail(email) != null) {
			
			rmodel.addAttribute("modelusr", service.getByEmail(email));
			//System.out.println(usr.getId());
			return "recover-password";
		} else {
			rmodel.addAttribute("msg", "Email Address doesn't exists.");
			return "forgot-password";
		}
	}

	@PostMapping("/restpsw")
	public String restpsw(@RequestParam("password") String password, @RequestParam("id") int id) {
		String psw = DigestUtils.md5DigestAsHex(password.getBytes());
		service.restPass(psw, id);
		return "login";
	}
}
