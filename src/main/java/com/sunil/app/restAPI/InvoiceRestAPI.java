package com.sunil.app.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.app.model.Product;
import com.sunil.app.service.ClientService;
import com.sunil.app.service.ProductService;

@RestController
public class InvoiceRestAPI {
	
	@Autowired
	private ClientService cservice;
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/loadRateBy/{id}")
	public int loadRateById(@PathVariable("id") int id){
		
//	Gson gson=new Gson();
//	return gson.toJson(pservice.getById(id));
		return pservice.getById(id);
	}
}
