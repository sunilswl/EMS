package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.Product;
import com.sunil.app.repository.ProductRepository;
import com.sunil.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public int getById(int id) {
		// TODO Auto-generated method stub
		return prodRepo.getById(id).getRate();
	}

}
