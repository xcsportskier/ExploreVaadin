package com.udemy.vaadinspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.vaadinspringboot.data.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John Smith", 20));
		students.add(new Student(2, "Smith John", 30));
		students.add(new Student(3, "Joe Doe", 40));
		return students;
	}

}
