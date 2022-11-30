package com.miniproject.service;


import com.miniproject.entity.Cart;
import com.miniproject.exception.CartException;

public interface CartService {

	public String addProductToCart(Cart cart, Long productID) throws CartException;
	
	public String deleteProductFromCartById(Long cartID, Long productID) throws CartException;
	
	
	
}
