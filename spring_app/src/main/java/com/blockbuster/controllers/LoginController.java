package com.blockbuster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.models.LoginTemplate;
import com.blockbuster.models.User;
import com.blockbuster.services.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginTemplate loginTemplate) {
		
		return ResponseEntity.ok(userService.login(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Void> logout() {
		userService.logout();
		
		return ResponseEntity.accepted().build();
	}
}
