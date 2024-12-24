package com.resrourant.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 * This class is responsible for bootstrapping the Spring Boot application.
 * It contains the main method that starts the Spring application context.
 *
 * {@link SpringBootApplication} annotation enables auto-configuration, component scanning,
 * and additional Spring Boot features.
 */
@SpringBootApplication
public class ServiceApplication {

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args); // Start the Spring Boot application
	}
}
