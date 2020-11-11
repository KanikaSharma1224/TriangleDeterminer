package com.triangledeterminer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {
	
	@RequestMapping("/")
	String greet() {
		return "Hello From Spring Boot !!!";
	}

}
