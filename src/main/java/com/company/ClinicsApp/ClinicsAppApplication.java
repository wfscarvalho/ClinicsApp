package com.company.ClinicsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.company.ClinicsApp.domain"})
public class ClinicsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicsAppApplication.class, args);
	}

}
