package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.entity.User;
import com.miniproject.exception.UserException;
import com.miniproject.serviceimplementation.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	private UserServiceImplementation userServiceImpl;
	
	
	@PostMapping("/addnew")
	public ResponseEntity<String> addUserHandler(@RequestBody User user) throws UserException{
		
		String userAdded = userServiceImpl.addUser(user);
		
		return new ResponseEntity<String>(userAdded, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{userID}")
	public ResponseEntity<String> updateUserHandler(@RequestBody User user, @PathVariable Long userID) throws UserException{
		
		String userUpdated = userServiceImpl.updateUser(user, userID);
		
		return new ResponseEntity<String>(userUpdated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable Long userId) throws UserException{
		
		String userDeleted = userServiceImpl.deleteUserById(userId);
		
		return new ResponseEntity<String>(userDeleted, HttpStatus.OK);
	}
	
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Long userId) throws UserException{
		
		User getUser = userServiceImpl.getUserById(userId);
		
		return new ResponseEntity<User>(getUser, HttpStatus.OK);
	}
	
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException{
		
		List<User> userList = userServiceImpl.getAllUsers();
		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	
}









