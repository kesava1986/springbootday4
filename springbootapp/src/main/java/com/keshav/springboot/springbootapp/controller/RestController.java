package com.keshav.springboot.springbootapp.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keshav.springboot.springbootapp.beans.Student;
import com.keshav.springboot.springbootapp.exception.StudentNotFoundException;
import com.keshav.springboot.springbootapp.repository.StudentRepository;
import com.keshav.springboot.springbootapp.service.StudentService;

@org.springframework.web.bind.annotation.RestController

/***
 * Controller for Student management application
 * @author kesav
 *
 */
@RequestMapping(value="springbootapp")
public class RestController {
	Logger logger = LoggerFactory.getLogger(RestController.class);
	
	 @Autowired
	    StudentService studentService;
	 
	 @Autowired
	 	StudentRepository StudentRepository;

	
	@RequestMapping(value = "/studentDetails")
	@GetMapping
	public List<Student> getStudentDetails() {
		return studentService.getStudent();
	}
	
	@RequestMapping(value = "/createStudents", method=RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" has been created!",HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") Long id,@RequestBody Student student) {
		
		if (!StudentRepository.existsById(id)) {
			throw new StudentNotFoundException();
		}
		studentService.update(student);
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" have been updated!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student st =studentService.findById(id);
		if (null == st) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" have been deleted!", HttpStatus.OK);
	}
	
	
	
	
	
}
