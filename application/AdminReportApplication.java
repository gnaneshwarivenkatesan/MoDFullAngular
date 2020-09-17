package com.mod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication

public class AdminReportApplication { //main class

	
	public static void main(String[] args) { //execution starts from here
		
		SpringApplication.run(AdminReportApplication.class, args);
		//for checking
		System.out.println("hello in main program"); 	
	}

}
