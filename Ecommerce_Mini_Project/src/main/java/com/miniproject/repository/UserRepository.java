package com.miniproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miniproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User where userEmail = ?1")
	public Optional<User> findByEmail(String email); 
	
}
