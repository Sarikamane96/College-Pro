package com.edu.SpringBoot.CollegemanementApp.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.SpringBoot.CollegemanementApp.Exception.ResourceNotFound;
import com.edu.SpringBoot.CollegemanementApp.entity.Teacher;
import com.edu.SpringBoot.CollegemanementApp.repository.TeacherRepository;
import com.edu.SpringBoot.CollegemanementApp.service.TeacherService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class TeacherserviceImpl implements TeacherService{


	private TeacherRepository teacherRepository;
	
	
	public TeacherserviceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}


	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}


	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
		
	}


	@Override
	public Teacher getTeacherById(long id) {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if(teacher.isPresent()) {
			return teacher.get();
		}
		else {
          
			throw new ResourceNotFound("(Teacher","Id",id);
		}
		
	}


	@Override
	public Teacher updateTeacher(Teacher teacher, long id) {
		(Teacher tech = new Teacher();
	 try {
		 tech = teacherRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Teacher","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 
	 	
	 tech.setFirstName(teacher.getFirstName());
	 tech.setLastName(teacher.getLastName());
	 tech.setEmail(teacher.getEmail());
	 tech.setContactno(Ttacher.getContactno());
	 tech.setAddress(teacher.getAddress());
	 tech.setGender(teacher.getGender());
	 tech.setCourse(teacher.getCourse());

	 teacherRepository.save(tech);
	return tech;
	}

	 @Override
		public void deleteTeacher(long id) {
			teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Teacher", "Id", id));
			teacherRepository.deleteById(id);
			
			
		}
	

	

}
