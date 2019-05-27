package com.keshav.springboot.springbootapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.keshav.springboot.springbootapp.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentExceptionController {
	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException exception){
		return new ResponseEntity<Object>("Student Not Found", HttpStatus.NOT_FOUND);
	}
}
