package com.edu.SpringBoot.CollegemanementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBoot.CollegemanementApp.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
