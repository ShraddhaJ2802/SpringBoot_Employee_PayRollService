package com.example.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollSystemApplication.class, args);
		log.info("Hello world");
		log.debug("Debug level");
		log.error("Error levell");
		log.warn("Warning level");
	}

}
