package com.vcube.sbsecapp01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/profile")
	public String profile(@RequestHeader("Authorization") String authHeader) {

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return "Token Missing!";
		}

		String token = authHeader.substring(7); // remove "Bearer "

		if (!JwtUtil.validateToken(token)) {
			return "Invalid Token!";
		}
//		String username = JwtUtil.extractUsername(token);

		return "Welcome !! this is your profile data!";
	}

}
