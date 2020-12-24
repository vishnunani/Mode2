package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.StudentDao;
import com.model.Student;
import com.service.StudentService;

@RestController
public class FirstController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String hello() {
		return "Welcome to spring ";
	}

	@GetMapping("/getstudent/{alias}")
	public Student getStudent(@PathVariable("alias") int userData) {
		return studentService.getStudentService(userData);
	}
	@PostMapping(value="/create")
	public Student createStudentdao( @RequestBody Student student) {
		
		System.out.println(student.getStudentNo());
		System.out.println(student.getStudentName());
		System.out.println(student.getMarks());
		
		return student;
		
	}
}
