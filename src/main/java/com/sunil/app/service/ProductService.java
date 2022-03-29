package com.sunil.app.service;

import java.util.List;

import com.sunil.app.model.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	int getById(int id);

}
