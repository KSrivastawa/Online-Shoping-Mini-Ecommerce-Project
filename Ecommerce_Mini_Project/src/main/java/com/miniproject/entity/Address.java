package com.miniproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	@Column(name = "house_number")
	private String houseNumber;
	private String street;
	private String city;
	private String pincode;
	private String state;
	
	@Pattern(regexp = "Home|Office|Current")
	@Column(name="address_type")
	private String addressType;
	
}




