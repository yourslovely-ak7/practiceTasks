package servlet;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.Claims;

public class TokenValidator {

	public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(TokenGenerator.getSecretKey()) // Use the same key
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}