package com.ts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.model.Registration;
import com.ts.service.RegistrationService;
@CrossOrigin("*")
@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
//	@PostMapping("/save")
//	public Registration save(@RequestBody Registration registration) {
//	 return registrationService.save(registration);
//	}
	
	@PostMapping("/save")
    public String save(@RequestBody Registration registration) {
        boolean isRegistered = registrationService.save(registration);
        return isRegistered ? "You are already registered." : "You are registered.";
    }
	
	@GetMapping("/get-all")
	public List<Registration> get(Registration registration) {
		return registrationService.get(registration);
	}
}

