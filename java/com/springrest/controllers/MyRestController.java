package com.springrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@GetMapping("/greet")
	public String greet()
	{
		return "Welcome Message for the Users";
	}
}
