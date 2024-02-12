package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.RegistrationRepository;
import com.ts.model.Registration;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepo;

//	public Registration save(Registration registration) {
//
//		if (registrationRepo.findByEmail(registration.getEmail()).isPresent()) {
//			return new Registration();
//
//		}
////		if (registrationRepo.findByName(registration.getName()).isPresent()) {
////			return new Registration();
////
////		}
//		if (registrationRepo.findByMobile(registration.getMobile()).isPresent()) {
//			return new Registration();
//
//		} else {
//
//			return registrationRepo.save(registration);
//		}
//	}
	 public boolean save(Registration registration) {
	        if (registrationRepo.findByEmail(registration.getEmail()).isPresent() ||
	            registrationRepo.findByName(registration.getName()).isPresent()) {
	            return true; // Already registered
	        } else {
	            registrationRepo.save(registration);
	            return false; // Registered successfully
	        }
	    }
	public List<Registration> get(Registration registration) {
		return registrationRepo.findAll();
	}

}
