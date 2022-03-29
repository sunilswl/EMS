package com.sunil.app.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sunil.app.model.Test;
import com.sunil.app.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService tservice;
	
	@GetMapping("/testupload")
	public String testUpload(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		model.addAttribute("tests",new Test());
		return "testupload";
	}
	
	@PostMapping("/addtest")
	public String addTest(@ModelAttribute Test test) {
		
		tservice.addTest(test);
		return "testupload";
	}
	
	@PostMapping("/addtest/save")
	public String addTest(@RequestParam("image") MultipartFile file, @ModelAttribute Test test) throws IOException {
		if (!file.isEmpty()) {
			String fileName=file.getOriginalFilename();
			String ext=fileName.substring(fileName.lastIndexOf(".")+1);
			String newfilename=test.getFname()+test.getLname()+"."+ext;
			
			test.setCphoto(newfilename);
			String dpath = "src/main/resources/static/uploads/photo/" + newfilename;
			
			Files.copy(file.getInputStream(), Paths.get(dpath),StandardCopyOption.REPLACE_EXISTING);
		}else {
			String oldfileName=tservice.getById(test.getId()).getCphoto();
			test.setCphoto(oldfileName);
		}
		tservice.addTest(test);
		return "redirect:/ttable";
	}
	
	@GetMapping("/ttable")
	public String getTestTbl(Model model) {
		model.addAttribute("tlist",tservice.getAllTest());
		return "testtable";
	}
	@GetMapping("/test/update")
	public String updateTest(@RequestParam int id, Model model) {
		model.addAttribute("tests",tservice.getById(id));
		return "testupload";
	}
}
