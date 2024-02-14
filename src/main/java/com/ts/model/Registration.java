package com.ts.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	    private String name;
	    private String email;
    private String date_time; // Assuming date_time represents date and time
   private Integer no_of_people; // Assuming no_ofpeople represents a numerical value
    private String special_request;
	
	
	
}
