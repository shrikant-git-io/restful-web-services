package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	@GetMapping( path="hello-world")
	public String helloWorld() {
		return "Hello World !";
	}
	
	
	@GetMapping( path="hello-world/{name}")
	public String pathVariable(@PathVariable String var) {
		return "Hello World ! " + var ;
	}

}
