package com.example.demo.security;

import com.example.demo.models.Profile;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtGenerator {

    @Value("${chatter-box.app.jwtSecret}")
    private String secret;
    @Value("${chatter-box.app.jwtExpirationMs}")
    private int expiration;

    private Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return getTokenBody(token)
                    .getSubject();
    }

    public Date getExpirationDate(String token) {
        return getTokenBody(token)
                .getExpiration();
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        if (token != null) {
            try {
                getTokenBody(token);
                return true;
            } catch(Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return false;
    }
}
