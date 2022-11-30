package com.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.entity.Cart;
import com.miniproject.exception.CartException;
import com.miniproject.serviceimplementation.CartServiceImplementation;

@RestController
public class CartController {

	@Autowired
	private CartServiceImplementation cartServiceImpl;
	
	
	@PostMapping("/addtocart/{productID}")
	public ResponseEntity<String> addToCartHandler(@RequestBody Cart cart, @PathVariable Long productID) throws CartException{
	
		String addToCart = cartServiceImpl.addProductToCart(cart, productID);
		
		return new ResponseEntity<String>(addToCart,HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/deletefromcart/{cartID}/{productID}")
	public ResponseEntity<String> deleteProductFromCartHandler(@PathVariable Long cartID, @PathVariable Long productID) throws CartException {
	
		String deleteFromCart = cartServiceImpl.deleteProductFromCartById(cartID, productID);
		
		return new ResponseEntity<String>(deleteFromCart, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
