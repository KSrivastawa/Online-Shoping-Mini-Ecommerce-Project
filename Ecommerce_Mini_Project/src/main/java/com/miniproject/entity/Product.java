package com.miniproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "product_price")
	private Double productPrice;
	
	@Column(name = "product_quantity")
	private Integer productQuantity;

	@Pattern(regexp = "STATIONARY|COSMETICS|GROCERY")
	@Column(name="product_categories")
	private String productCategories;
	
}
