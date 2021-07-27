package com.natWest.demo.controller;

import java.util.Arrays;
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

//	@GetMapping("/test")
//	public String testRequest() {
//		return "Hello";
//	}
//
//	@GetMapping("/get")
//	public Student getStudent() {
//		return new Student("Bob", "Bobson", 19, "bbson@edu.ac.uk");
//
//	}
//Read
	@GetMapping(path = "readfromdb")
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<List<Student>>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/findbyId/{id}")
	public ResponseEntity<Student> findbyId(@PathVariable("id") Long id) {
		return new ResponseEntity<Student>(this.service.findbyId(id), HttpStatus.FOUND);
	}
//create
	@PostMapping("/create")
	public ResponseEntity<Student>create(@RequestBody Student student) {
		return new ResponseEntity<Student>(this.service.create(student),HttpStatus.CREATED);
	}

//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable("id")Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(this.service.update(id, student),HttpStatus.ACCEPTED);
	}
	
	
//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> update(@PathVariable Long id) {
		
		return new ResponseEntity<Boolean>(this.service.delete(id),HttpStatus.NO_CONTENT);
	}
	
}
