package com.miniproject.service;

import java.util.List;

import com.miniproject.entity.Order;
import com.miniproject.exception.OrderException;

public interface OrderService {

	public String addOrder(Order order, Long userID) throws OrderException;
	
	public String updateOrder(Order order, Long userID) throws OrderException;
	
	public String deleteOrderById(Long orderID) throws OrderException;
	
	public Order getOrderById(Long orderID) throws OrderException;
	
	public List<Order> getAllOrders() throws OrderException;
	
}
