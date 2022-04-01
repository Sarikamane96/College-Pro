package com.edu.SpringBoot.CollegemanementApp.service;

import java.util.List;

import com.edu.SpringBoot.CollegemanementApp.entity.Teacher;

public interface TeacherService {
	
	Teacher saveTeacher(Teacher teacher);
	List<Teacher> getAllTeacher();
	Teacher getTeacherById(long id);
	Teacher updateTeacher(Teacher teacher, long id);
	void deleteTeacher(long id);
}
