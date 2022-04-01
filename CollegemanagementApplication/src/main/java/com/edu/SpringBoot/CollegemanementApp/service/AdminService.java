package com.edu.SpringBoot.CollegemanementApp.service;

import java.util.List;

import com.edu.SpringBoot.CollegemanementApp.entity.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);

	List<Admin> getAllAdmin();

	Admin getAdminById(long id);

	List<Admin> getAdminByFirstName(String firstName);

	List<Admin> getAdminByLastName(String lastName);

	List<Admin> getAdminByFirstNameOrLastName(String firstName, String lastName);

	List<Admin> getAdminByFirstNameAndLastName(String firstName, String lastName);

	Admin getAdminFullNameById(long id);

	List<Admin> getAdminInDescOrder();

	Admin updateAdmin(Admin admin, long id);

	void deleteAdmin(long id);

	Admin getAdminById(Long id);
	

}