package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.entity.Product;
import com.miniproject.exception.ProductException;
import com.miniproject.serviceimplementation.ProductServiceImplementation;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImplementation productServiceImpl;
	
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProductHandler(@RequestBody Product product) throws ProductException{
		
		String productAdded = productServiceImpl.addProduct(product);
		
		return new ResponseEntity<String>(productAdded, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/updateproduct/{productID}")
	public ResponseEntity<String> updateProductHandler(@RequestBody Product product, @PathVariable Long productID) throws ProductException{
		
		String productUpdated = productServiceImpl.updateProduct(product, productID);
		
		return new ResponseEntity<String>(productUpdated, HttpStatus.ACCEPTED);
	}
	                
	
	@DeleteMapping("/deleteproduct/{productID}")
	public ResponseEntity<String> deleteProductHandler(@PathVariable Long productID) throws ProductException {
		
		String productDeleted = productServiceImpl.deleteProductById(productID);
		
		return new ResponseEntity<String>(productDeleted, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getproduct/{productID}")
	public ResponseEntity<Product> getProductHandler(@PathVariable Long productID) throws ProductException {
		
		Product getProduct = productServiceImpl.getProductById(productID);
		
		return new ResponseEntity<Product>(getProduct, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getAllProductHandler() throws ProductException {
		
		List<Product> getProducts = productServiceImpl.getAllProducts();
		
		return new ResponseEntity<List<Product>>(getProducts, HttpStatus.OK);
		
	}
	
	
	
}
















