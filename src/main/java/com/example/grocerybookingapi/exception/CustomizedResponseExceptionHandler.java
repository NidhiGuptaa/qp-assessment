package com.example.grocerybookingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomizedResponseExceptionHandler {

	//custom exception
	@ExceptionHandler(ExceptionResponse.class)
	public ResponseEntity<String> handleAllExceptions(ExceptionResponse ee){
		return new ResponseEntity<String>("something went wrong, please pass the correct details", HttpStatus.BAD_REQUEST);
	}
	
}