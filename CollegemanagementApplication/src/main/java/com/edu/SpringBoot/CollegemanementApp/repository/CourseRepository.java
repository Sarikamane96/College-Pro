package com.edu.SpringBoot.CollegemanementApp.repository;

import java.util.List;
import java.util.Optional;

import com.edu.SpringBoot.CollegemanementApp.entity.Course;

public interface CourseRepository {

	List<Course> findAll();

	Optional<Course> findById(long id);

	void deleteById(long id);

	Course save(Course co);

}
