package com.edu.SpringBoot.CollegemanementApp.repository;

import java.util.List;
import java.util.Optional;

import com.edu.SpringBoot.CollegemanementApp.entity.Admin;


public interface AdminRepository {

	List<Admin> findAll();

	Admin save(Admin admin);

	Optional<Admin> findById(long id);

	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	List<Admin> findByFirstNameAndLastName(String firstName, String lastName);

	List<Admin> findByFirstNameOrLastName(String firstName, String lastName);

	Admin findAdminById(Long id);

	Admin findAdminFullNameById(long id);

	List<Admin> findAdminInDescOrder();

	void deleteById(long id);

}
