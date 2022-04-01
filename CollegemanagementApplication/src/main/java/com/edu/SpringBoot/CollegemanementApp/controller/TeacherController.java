package com.edu.SpringBoot.CollegemanementApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.edu.SpringBoot.CollegemanementApp.entity.Student;
import com.edu.SpringBoot.CollegemanementApp.entity.Teacher;
import com.edu.SpringBoot.CollegemanementApp.service.TeacherService;
import com.edu.SpringBoot.CollegemanementApp.serviceImpl.TeacherserviceImpl;


@Controller
@RequestMapping("/api/student")
public class TeacherController {
	private TeacherService teacherService;

	public TeacherController(TeacherserviceImpl teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	@PostMapping
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Teacher> getAllTeacher()
	{
		return teacherService.getAllTeacher();
	}
	@GetMapping("{id}")
	public ResponseEntity<Teacher>getTeacherById(@PathVariable("id") long id) {
		return new ResponseEntity<Teacher>(teacherService.getTeacherById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") long id, @RequestBody Teacher teacher){
		
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		teacherService.deleteTeacher(id);
		return new ResponseEntity<String> ("Teacher Record Is Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/")
	String index()
	{
		return"index";
	}
}
