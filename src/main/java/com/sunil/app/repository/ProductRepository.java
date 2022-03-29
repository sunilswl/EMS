package com.sunil.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
