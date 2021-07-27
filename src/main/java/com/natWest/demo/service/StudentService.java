package com.natWest.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


import com.natWest.demo.domain.Student;

@Service
public class StudentService {

	
	//Read all
	

	public List<Student> readAll() {
		List<Student> list = Arrays.asList(new Student(1L,"Bob", "Bobson", 19, "bbson@edu.ac.uk"),
				new Student(2L,"Steve", "Stevenson", 18, "stevenson@edu.ac.uk"));
		return list;

	}

	
	
	
	

	


	
}
