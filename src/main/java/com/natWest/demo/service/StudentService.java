package com.natWest.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.natWest.demo.domain.Student;
import com.natWest.demo.repo.StudentRepo;

@Service
public class StudentService {

	public StudentRepo repo;
	
	//Read all

//	public List<Student> readAll() {
//		List<Student> list = Arrays.asList(new Student(1L,"Bob", "Bobson", 19, "bbson@edu.ac.uk"),
//				new Student(2L,"Steve", "Stevenson", 18, "stevenson@edu.ac.uk"));
//		return list;
//
//	}

	public StudentService(StudentRepo repo) {
		super();
		this.repo = repo;
	}
	
//read all
	public List<Student> readAll() {
		return this.repo.findAll();
	}
	
	//Create
	public Student create(Student student) {
		return this.repo.saveAndFlush(student);
	}
		
	//Read findbyId
	public Student findbyId(Long Id) {
		return this.repo.findById(Id).orElseThrow();
	}
	
	//Update

	public Student update(Long id, Student student) {
		Student exists = this.repo.getById(id);
		exists. setFirstName(student.getFirstName());
		exists. setLastName(student.getLastName());
		exists. setAge(student.getAge());
		exists. setEmail(student.getEmail());
		Student Updated = this.repo.save(exists);		
		return Updated;
	}

	//delete
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	
}
