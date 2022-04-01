package com.edu.SpringBoot.CollegemanementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBoot.CollegemanementApp.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
