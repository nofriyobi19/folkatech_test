package com.folkatechtest.folkatechtest.services;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private String SECRET_KEY;

    public JwtService() {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            SECRET_KEY = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<String, Object>();

        return Jwts.builder()
                   .claims().add(claims)
                   .subject(username)
                   .and()
                   .signWith(getKey())
                   .compact();
    }

    private SecretKey getKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String getUsername(String token) {
        var claims = getClaims(token);
        return claims.getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsername(token);
        return username.equals(userDetails.getUsername());
    }
}
