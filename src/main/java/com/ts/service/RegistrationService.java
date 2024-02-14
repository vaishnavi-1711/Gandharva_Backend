package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.RegistrationDao;
import com.ts.model.Registration;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDao registrationDao;

	 public boolean save(Registration registration) {
	        if (registrationDao.findByEmail(registration.getEmail()).isPresent() ||
	        		registrationDao.findByName(registration.getName()).isPresent()) {
	            return true; // Already registered
	        } else {
	        	registrationDao.save(registration);
	            return false; // Registered successfully
	        }
	    }
	public List<Registration> get(Registration registration) {
		return registrationDao.findAll();
	}

}
