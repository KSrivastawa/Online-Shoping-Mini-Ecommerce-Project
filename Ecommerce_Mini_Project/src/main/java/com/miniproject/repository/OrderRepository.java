package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
