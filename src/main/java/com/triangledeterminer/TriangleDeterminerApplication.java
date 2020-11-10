package com.triangledeterminer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TriangleDeterminerApplication {

	@RequestMapping("/")
	String display() {
		return "Hello World from Triangle Determiner !!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(TriangleDeterminerApplication.class, args);
	}

}
