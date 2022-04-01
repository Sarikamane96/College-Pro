package com.edu.SpringBoot.CollegemanementApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.SpringBoot.CollegemanementApp.entity.Student;
import com.edu.SpringBoot.CollegemanementApp.entity.Teacher;
import com.edu.SpringBoot.CollegemanementApp.service.CourseService;
import com.edu.SpringBoot.CollegemanementApp.service.StudentService;
import com.edu.SpringBoot.CollegemanementApp.service.TeacherService;

//import antlr.collections.List;

@Controller
public class UIController {
	
	private StudentService studentService;
	private TeacherService teacherService;
	private CourseService courseService;
	
	
@Autowired	
public UIController(StudentService studentService, TeacherService teacherService,
		 CourseService courseService) {
		super();
		this.studentService = studentService;
		this.teacherService = teacherService;
		this.courseService = courseService;
	}

@GetMapping("/")
	
	String index() {
		return "index";/// index.html
	}

// student 
@GetMapping("/registration")
public String stuRegistrationForm(Model model) {
	Student student = new Student();
	model.addAttribute("student", student);
    return "add-student";
}

@PostMapping("/saveStudent")
public String saveStudent(@Validated  Student student, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    studentService.saveStudent(student);
	List<Student> students =  studentService.getAllStudent();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getStudents";
    
}

@GetMapping("/getStudents")
public String getAllStudents(Model model) {
	
	List<Student> students =  studentService.getAllStudent();
	
	model.addAttribute("students", students);
	
    return "list-student";}



//student 
@GetMapping("/tearegistration")
public String teaRegistrationForm(Model model) {
	Teacher teacher = new Teacher();
	model.addAttribute("teacher", teacher);
 return "add-teacher";
}

@PostMapping("/saveTeacher")
public String saveTeacher(@Valid  Teacher teacher, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
 teacherService.saveTeacher(teacher);
	List<Teacher> teachers =  teacherService.getAllTeacher();
 model.addAttribute("successMessage", "Details are saved successfully");
	}
 return "redirect:/getTeachers";
 
}

@GetMapping("/getTeachers")
public String getAllTeachers(Model model) {
	
	List<Teacher> teachers =  teacherService.getAllTeacher();
	
	model.addAttribute("teachers", teachers);
	
 return "list-teacher";}


}