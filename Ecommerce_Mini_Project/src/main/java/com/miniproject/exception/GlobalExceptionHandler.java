package com.miniproject.exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyError> notFoundExceptionExceptionHandler(NotFoundException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exceptionExceptionHandler(Exception exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserSessionException.class)
	public ResponseEntity<MyError> userSessionExceptionHandler(UserSessionException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> userExceptionHandler(UserException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> productExceptionHandler(ProductException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyError> CartExceptionHandler(CartException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyError> orderExceptionHandler(OrderException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyError> addressExceptionHandler(AddressException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));  
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
