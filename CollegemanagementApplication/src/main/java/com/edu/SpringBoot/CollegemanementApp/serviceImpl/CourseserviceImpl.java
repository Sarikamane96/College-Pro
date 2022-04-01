package com.edu.SpringBoot.CollegemanementApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBoot.CollegemanementApp.Exception.ResourceNotFound;
import com.edu.SpringBoot.CollegemanementApp.entity.Course;
import com.edu.SpringBoot.CollegemanementApp.repository.CourseRepository;
import com.edu.SpringBoot.CollegemanementApp.service.CourseService;

public class CourseserviceImpl {
	@Service
	public class CourseServiceImpl implements CourseService{


		private CourseRepository courseRepository;
		
		
		public CourseServiceImpl(CourseRepository courseRepository) {
			super();
			this.courseRepository = courseRepository;
		}


		@Override
		public Course saveCourse(Course course) {
			return courseRepository.save(course);
		}


		@Override
		public List<Course> getAllCourse() {
			return courseRepository.findAll();
			
		}


		@Override
		public Course getCourseById(long id) {
			Optional<Course> course = courseRepository.findById(id);
			if(course.isPresent()) {
				return course.get();
			}
			else {
	          
				throw new ResourceNotFound("Course","Id",id);
			}
			
		}


		@Override
		public Course updateCourse(Course course, long id) {
			Course co = new Course();
		 try {
			   co = courseRepository.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFound("Course","Id",id));
		} catch (ResourceNotFound e) {
			
			e.printStackTrace();
		}
		 co.setCourseName(course.getCourseName());
		 co.setClasse(course.getClasse());
		 co.setDepartment(course.getDepartment());
		 
		 courseRepository.save(co);
		return co;
		}

		 @Override
			public void deleteCourse(long id) {
			 courseRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Course", "Id", id));
			 courseRepository.deleteById(id);
				
				
			}
		
		

	}

}
