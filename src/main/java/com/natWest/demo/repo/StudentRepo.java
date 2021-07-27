package com.natWest.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natWest.demo.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
