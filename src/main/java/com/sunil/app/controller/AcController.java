package com.sunil.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunil.app.model.Account;
import com.sunil.app.model.SubAccount;
import com.sunil.app.service.AccountService;

@Controller
public class AcController {
	@Autowired
	private AccountService acservice;

	@GetMapping("/ac")
	public String getAC(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("subaccount", new SubAccount());
		List<Account> acclist = acservice.getAllAccount();
		model.addAttribute("aclist", acclist);
		return "actype";
	}

	@GetMapping("/actypes")
	public String getACtypes(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("aclist", acservice.getAllAC());
		return "actypes";
	}

	@PostMapping("/actype")
	public String addACtype(@ModelAttribute SubAccount subaccount) {
		acservice.addACtype(subaccount);
		return "redirect:/actypes";
	}

	@GetMapping("actype/update")
	public String updateACtypes(@RequestParam int id , HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("subaccount", acservice.getById(id));
		model.addAttribute("aclist", acservice.getAllAccount());
		return "actype";
	}
	@PostMapping("actype/update")
	public String updateACtypes(@ModelAttribute SubAccount subaccount, HttpSession  session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		acservice.updateACtype(subaccount);
		return "redirect:actypes";
	}
}
