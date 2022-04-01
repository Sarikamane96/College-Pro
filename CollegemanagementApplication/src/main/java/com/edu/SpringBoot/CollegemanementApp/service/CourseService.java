package com.edu.SpringBoot.CollegemanementApp.service;

import java.util.List;

//import com.edu.SpringBoot.CollegemanementApp.controller.List;
import com.edu.SpringBoot.CollegemanementApp.entity.Course;

public interface CourseService {

	Course saveCourse(Course course);

	List<Course> getAllCourse();

	Course getCourseById(long id);

	void deleteCourse(long id);

	Course updateCourse(Course course, long id);

}
