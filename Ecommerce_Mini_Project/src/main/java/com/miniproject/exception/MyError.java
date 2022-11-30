package com.miniproject.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyError {

	private LocalDateTime localDateTime;
	private String message;
	private String description;
	
}
