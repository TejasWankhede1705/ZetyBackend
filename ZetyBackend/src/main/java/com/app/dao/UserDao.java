package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entity.User;


public interface UserDao extends JpaRepository<User, Long> {
	boolean existsByEmail(String emial);
	
	Optional<User> findByEmail(String email);
	
	Optional<User>findByEmailAndPassword(String email, String password);


//	User findByusername(String email);
}
