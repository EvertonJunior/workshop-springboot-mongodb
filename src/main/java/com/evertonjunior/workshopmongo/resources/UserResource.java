package com.evertonjunior.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evertonjunior.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findall(){
		User maria = new User("1","Maria Silva", "maria@gmail.com");
		User alex = new User("2","Alex Muralha", "alex@gmail.com");
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(users);
	}
}
