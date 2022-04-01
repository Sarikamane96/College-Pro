package com.edu.SpringBoot.CollegemanementApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBoot.CollegemanementApp.entity.User;

public interface UserRepositroy {
	public interface UserRepository extends JpaRepository<User, Integer>{
		Optional<User> findByUserName(String userName);


}
}
