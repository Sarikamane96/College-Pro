package com.edu.SpringBoot.CollegemanementApp.controller;

import java.util.List;

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

import com.edu.SpringBoot.CollegemanementApp.entity.Course;
import com.edu.SpringBoot.CollegemanementApp.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		return new ResponseEntity<Course>(courseService.saveCourse(course),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Course> getAllCourse()
	{
		return courseService.getAllCourse();
	}
	@GetMapping("{id}")
	public ResponseEntity<Course>getCourseById(@PathVariable("id") long id) {
		return new ResponseEntity<Course>(courseService.getCourseById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course){
		
		return new ResponseEntity<Course>(courseService.updateCourse(course, id),HttpStatus.OK);
		
	}
	

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") long id){
		courseService.deleteCourse(id);
		return new ResponseEntity<String> ("Course Record Is Deleted", HttpStatus.OK);
	}

	

	
	
}
