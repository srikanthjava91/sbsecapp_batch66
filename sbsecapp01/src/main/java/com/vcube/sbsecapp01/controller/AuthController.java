package com.vcube.sbsecapp01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.sbsecapp01.dto.LoginRequest;

@RestController
public class AuthController {

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {

		if (loginRequest.getUsername().equalsIgnoreCase("Srikanth") && loginRequest.getPassword().equals("Sri#123")) {
			String token = JwtUtil.generateToken(loginRequest.getUsername());
			return "JWT Token: " + token;
		} else {
			return "invalid user credentials ";
		}

	}

}
