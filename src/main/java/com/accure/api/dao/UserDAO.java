package com.accure.api.dao;

import com.accure.api.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDAO extends JpaRepository<User, Long> {
	
Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
}
