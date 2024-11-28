package servlet;


import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenGenerator {
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public static String generateToken(int userId, String userName, String name, String userType) 
    {
        return Jwts.builder()
                .setSubject(userName)
                .claim("userId", userId)
                .claim("name", name)
                .claim("userType", userType)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY)
                .compact();
    }
	
	public static SecretKey getSecretKey() 
	{
        return SECRET_KEY;
    }
}

