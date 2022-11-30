package com.miniproject.service;

import java.util.List;

import com.miniproject.entity.Product;
import com.miniproject.exception.ProductException;


public interface ProductService {

	public String addProduct(Product product) throws ProductException;
	
	public String updateProduct(Product product, Long productId) throws ProductException;
	
	public String deleteProductById(Long productID) throws ProductException;
	
	public Product getProductById(Long productID) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
	
}
