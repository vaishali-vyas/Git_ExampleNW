package com.natWest.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natWest.demo.domain.Student;
import com.natWest.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentService service;
	
	
	@Autowired
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/test")
	public String testRequest() {
		return "Hello";
	}

	@GetMapping("/get")
	public Student getStudent() {
		return new Student("Bob", "Bobson", 19, "bbson@edu.ac.uk");

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>>readAll() {
		return new ResponseEntity<List<Student>>(this.service.readAll(), HttpStatus.OK);
	}

}
