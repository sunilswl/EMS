package com.sunil.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sunil.app.model.Invoice;
import com.sunil.app.model.Invoicedetails;
import com.sunil.app.service.ClientService;
import com.sunil.app.service.InvoiceService;
import com.sunil.app.service.ProductService;

@Controller
public class InvoiceController {
	@Autowired
	private ClientService cservice;
	@Autowired
	private ProductService pservice;
	@Autowired
	private InvoiceService iservice;
	
	@GetMapping("/invoice")
	public String getInovice(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("clist", cservice.getAllClient());
		model.addAttribute("plist", pservice.getAllProduct());
		System.out.println(pservice.getAllProduct());
		
		return "invoice";
	}
	
	@PostMapping("/invoice/save")
	public String saveInovice(@ModelAttribute Invoice invoice) {
		iservice.addInvoice(invoice);
		
		return "invoice";
	}
}
