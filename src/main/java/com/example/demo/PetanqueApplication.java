package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Petanque application.
 * This class is responsible for bootstrapping and starting the Spring Boot application.
 */
@SpringBootApplication
public class PetanqueApplication {

	/**
	 * The main method that launches the Petanque application.
	 * It initializes the Spring Boot framework, sets up the application context, and starts the embedded server.
	 *
	 * @param args command-line arguments (if any) passed during application startup
	 */
	public static void main(String[] args) {
		SpringApplication.run(PetanqueApplication.class, args);
	}
}
