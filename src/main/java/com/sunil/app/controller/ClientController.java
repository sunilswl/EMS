package com.sunil.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sunil.app.model.Client;
import com.sunil.app.service.AccountService;
import com.sunil.app.service.ClientService;


@Controller
public class ClientController {
	@Autowired
	private ClientService cservice;
	
	@Autowired
	private AccountService aservice;

	@GetMapping("/addclient")
	public String getClientform(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("client", new Client());
		model.addAttribute("aclist", aservice.getAllAccount());
		model.addAttribute("saclist", aservice.getAllAC());
		return "clientform";
	}
	@GetMapping("/client/update")
	public String updateClientform(@RequestParam int id,HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("client", cservice.getById(id));
		model.addAttribute("aclist", aservice.getAllAccount());
		model.addAttribute("saclist", aservice.getAllAC());
		return "clientform";
	}
	
	@GetMapping("/allclient")
	public String getAllClient(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("clientlist",cservice.getAllClient());
		return "clients";
	}
	
	@GetMapping("/deposit")
	public String getdepositform(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("clientlist",cservice.getAllClient());
		return "depositform";
	}
	
	@PostMapping("/addclient/save")
	public String addClientd(@RequestParam("clientphoto") MultipartFile file, @RequestParam("signimage") MultipartFile file1, @ModelAttribute Client client, HttpSession session) throws IOException {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		if (file!=null) {
			String fileName=file.getOriginalFilename();
			String ext=fileName.substring(fileName.lastIndexOf(".")+1);
			String newfilename=client.getFname()+client.getLname()+"."+ext;
			
			client.setCphoto(newfilename);
			String dpath = "src/main/resources/static/uploads/photo/" + newfilename;
			Files.copy(file.getInputStream(), Paths.get(dpath),StandardCopyOption.REPLACE_EXISTING);
		}
		if (file1!=null) {
			String fileName1=file1.getOriginalFilename();
			String ext1=fileName1.substring(fileName1.lastIndexOf(".")+1);
			String newfilename1=client.getFname()+client.getLname()+"_sign."+ext1;
			
			client.setSignimg(newfilename1);
			String dpath = "src/main/resources/static/uploads/signature/" + newfilename1;
			Files.copy(file.getInputStream(), Paths.get(dpath),StandardCopyOption.REPLACE_EXISTING);
		}
		cservice.addClient(client);
		return "redirect:/allclient";
	}
	
}
