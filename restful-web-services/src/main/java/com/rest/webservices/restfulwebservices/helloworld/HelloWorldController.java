package com.rest.webservices.restfulwebservices.helloworld;

import com.fasterxml.jackson.annotation.JsonView;
import com.rest.webservices.restfulwebservices.config.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private AcmeProperties acmeProperties;
	
	@GetMapping( path="hello-world")
	public String helloWorld() {
		return "Hello World !";
	}
	
	@GetMapping( path="hello-world-internationalized")
	public String helloWorldInternationalized() {
		//set Accepted-language in message header
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
	
	@GetMapping( path="hello-world/{name}")
	public String pathVariable(@PathVariable String var) {
		return "Hello World ! " + var ;
	}

	@GetMapping( path="hello-world/config")
	public ResponseEntity<AcmeProperties> getConfig(){
	return new ResponseEntity<AcmeProperties>(acmeProperties, HttpStatus.OK);
	}

}
