package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResouce {
	
	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
		
	}
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id) {
		User user = service.find(id);
		if(user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		return service.find(id);
		
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saveduser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
