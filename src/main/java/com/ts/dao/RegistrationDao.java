package com.ts.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.model.Registration;


@Repository
public interface RegistrationDao extends JpaRepository<Registration, Long> {

	Optional<Registration> findByEmail(String email);
	
	Optional<Registration> findByName(String name);
	

	
	
}
