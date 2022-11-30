package com.miniproject.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.entity.Address;
import com.miniproject.entity.User;
import com.miniproject.exception.AddressException;
import com.miniproject.exception.UserException;
import com.miniproject.repository.AddressRepository;
import com.miniproject.repository.UserRepository;
import com.miniproject.service.AddressService;


@Service
public class AddressServiceImplementation implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public String addAddress(Address address, Long userId) throws AddressException, UserException {
			
			User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User not found..."));
			
			if(user != null) {
				user.getAddress().add(address);
				
				userRepository.save(user);
				
				return "Address added and assigned to User!";
			}
			
			throw new AddressException("address not added...");
		
	}

	@Override
	public String updateAddress(Address address, Long userID) throws AddressException, UserException {
		
		String message = "Address not Added!";
		
		Optional<Address> addressOptional = addressRepository.findById(address.getAddressId());
		
		if(addressOptional.isPresent()) {
			
			User user = userRepository.findById(userID).orElseThrow(()-> new UserException("user not found..."));
		
			if(user != null) {
				user.getAddress().set(0, address);
				userRepository.save(user);
				
				message = "Address updated!";
			}
			
		}
		
		return message;
	}

	@Override
	public String deleteAddressById(Long userID, Long addressID) throws AddressException, UserException {
		
		String message = "Address not Deleted!";
			
			User user = userRepository.findById(userID).orElseThrow(()-> new UserException("user not found..."));
		
			if(user != null) {
					
				Address address = addressRepository.findById(addressID).orElseThrow(()-> new UserException("address not found..."));
				
				if(address != null) {
					
					for(int i=0; i<user.getAddress().size(); i++) {
						if(user.getAddress().get(i).getAddressId()==addressID) {
							user.getAddress().remove(i);
						}
					}
				
					addressRepository.delete(address);
					message = "Address deleted!";
				}
				
			}

		return message;
		
	}

	@Override
	public Address getAddressById(Long addressID) throws AddressException {

		Address address = addressRepository.findById(addressID).orElseThrow(()-> new AddressException("address not found with given id: "+addressID));

		return address;
	}

	@Override
	public List<Address> getAllAddresses() throws AddressException {

		List<Address> addresses = addressRepository.findAll();

		return addresses;
	}

}
