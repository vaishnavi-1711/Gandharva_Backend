package com.ts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ts.model")
public class GandharvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GandharvaApplication.class, args);

	}
}
