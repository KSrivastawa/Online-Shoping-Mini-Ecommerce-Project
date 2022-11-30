package com.miniproject.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.entity.Address;
import com.miniproject.entity.Order;
import com.miniproject.entity.User;
import com.miniproject.exception.OrderException;
import com.miniproject.repository.AddressRepository;
import com.miniproject.repository.OrderRepository;
import com.miniproject.repository.UserRepository;
import com.miniproject.service.OrderService;


@Service
public class OrderServiceImplementation implements OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	
	@Override
	public String addOrder(Order order, Long userID) throws OrderException {

		String message = "Not Ordered!";
		
		User user = userRepository.findById(userID).orElseThrow(()-> new OrderException("User not found!"));
		
		if(user != null) {
			
			if(user.getAddress().get(0) != null) {
				
				orderRepository.save(order);
				
				message = "Order Saved Successfully!";
				
			}else {
				throw new OrderException("Address not found for this respective user!");
			}
			
		}
		
		return message;
		
	}

	@Override
	public String updateOrder(Order order, Long userID) throws OrderException {
		String message = "Order Not updated!";
		
		User user = userRepository.findById(userID).orElseThrow(()-> new OrderException("User not found!"));
		
		if(user != null) {
			
			orderRepository.save(order);
			
			message = "Order Updated Successfully!";
			
		}
		
		return message;
	}

	@Override
	public String deleteOrderById(Long orderID) throws OrderException {

		String message = "Not Deleted!";
		
		Order order = orderRepository.findById(orderID).orElseThrow(()-> new OrderException("Order Not Found!"));
		
		if(order != null) {
			orderRepository.delete(order);
		}
		
		return message;
		
	}

	@Override
	public Order getOrderById(Long orderID) throws OrderException {
		
		Order order = orderRepository.findById(orderID).orElseThrow(()-> new OrderException("Order Not Found!"));
		
		return order;
	}

	@Override
	public List<Order> getAllOrders() throws OrderException {

		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}

	
	
}







