
package com.vcube.sbsecapp01.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final String SECRET_KEY = "srikanthsrikanthsrikanthsrikanth"; // min 32 chars
	
	public static SecretKey getKey() {
	    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	public static String generateToken(String username) {

		long expTime = System.currentTimeMillis() + (1000 * 60 * 1); // 1 min
		SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		return Jwts.builder().subject(username).expiration(new Date(expTime)).signWith(key) // ✅ new way
				.compact();
	}
	
	
	public static boolean validateToken(String token) {
	    try {
	        Jwts.parser()
	                .verifyWith(getKey())   // new method in 0.12.x
	                .build()
	                .parseSignedClaims(token);

	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
//	// ✅ Extract Username
//	public static String extractUsername(String token) {
//		return Jwts.parserBuilder().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getSubject();
//	}

	// ✅ Validate Token
//	public static boolean validateToken(String token) {
//	    try {
//	        Jwts.parserBuilder()
//	                .verifyWith(getKey())
//	                .build()
//	                .parseSignedClaims(token);
//	        return true;
//	    } catch (Exception e) {
//	        return false;
//	    }
}