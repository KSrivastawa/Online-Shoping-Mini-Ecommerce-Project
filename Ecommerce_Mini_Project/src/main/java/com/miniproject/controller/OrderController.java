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

import com.miniproject.entity.Order;
import com.miniproject.exception.OrderException;
import com.miniproject.serviceimplementation.OrderServiceImplementation;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImplementation orderServiceImpl;
	
	
	@PostMapping("/addorder/{userID}")
	public ResponseEntity<String> addOrderHandler(@RequestBody Order order, @PathVariable Long userID) throws OrderException {
		
		String addOrder = orderServiceImpl.addOrder(order, userID);
		
		return new ResponseEntity<String>(addOrder, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateorder/{userID}")
	public ResponseEntity<String> updateOrderHandler(@RequestBody Order order, @PathVariable Long userID) throws OrderException {
		
		String updatdOrder = orderServiceImpl.updateOrder(order, userID);
		
		return new ResponseEntity<String>(updatdOrder, HttpStatus.CREATED);
		
	}
	
	
	
	@DeleteMapping("/deleteorder/{orderID}")
	public ResponseEntity<String> deleteOrderHandler(@PathVariable Long orderID) throws OrderException{
		
		String deleteOrder = orderServiceImpl.deleteOrderById(orderID);
		
		return new ResponseEntity<String>(deleteOrder, HttpStatus.OK); 
		
	}
	
	
	@GetMapping("/getorder/{orderID}")
	public ResponseEntity<Order> getOrderByIdHandler(@PathVariable Long orderID) throws OrderException {
		
		Order getOrder = orderServiceImpl.getOrderById(orderID);
		
		return new ResponseEntity<Order>(getOrder, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getallorder")
	public ResponseEntity<List<Order>> getAllOrderHandler() throws OrderException {
		
		List<Order> orders = orderServiceImpl.getAllOrders();
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
















