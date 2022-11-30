package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
