package com.hasA_relationShip;

public class Address {

	String city;
	String pincode;
	String state;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String pincode, String state) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}
	
	
	
}
