package com.miniproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	
}
