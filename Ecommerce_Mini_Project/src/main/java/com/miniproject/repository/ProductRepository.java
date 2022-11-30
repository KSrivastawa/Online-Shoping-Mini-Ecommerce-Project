package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miniproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("from Product where productName = ?1")
	public Product findProductByName(String productName);
	
}
