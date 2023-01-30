package com.lab.studentDebate.service;

import java.util.List;

import com.lab.studentDebate.model.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);
}
