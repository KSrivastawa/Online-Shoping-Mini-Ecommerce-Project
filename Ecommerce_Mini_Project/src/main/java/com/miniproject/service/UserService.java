package com.miniproject.service;

import java.util.List;

import com.miniproject.entity.User;
import com.miniproject.exception.UserException;

public interface UserService {

	public String addUser(User user) throws UserException;
	
	public String updateUser(User user, Long userID) throws UserException;
	
	public String deleteUserById(Long userID) throws UserException;
	
	public User getUserById(Long userID) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
	
}
