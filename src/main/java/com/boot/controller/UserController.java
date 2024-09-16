package com.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.User;
import com.boot.service.UserService;

@RestController
@CrossOrigin

@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	public UserService sr;

	// Endpoint for user registration
    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody User u) {
        try {
            sr.addUser(u);
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("User registration failed.");
        }
    }

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody User loginRequest) {
		boolean isValidUser = sr.validateUser(loginRequest.getuName(), loginRequest.getuPassword());
		Map<String, String> response = new HashMap<>();
		if (isValidUser) {
			response.put("message", "Login successful");
			return ResponseEntity.ok(response);
		} else {
			response.put("error", "Invalid username or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
	}

}
