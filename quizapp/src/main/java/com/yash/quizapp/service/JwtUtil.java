package com.yash.quizapp.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String generateToken(String email, Integer adminId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        String subject  = email + ":" + adminId.toString();

        return JWT.create()
                .withSubject(subject)
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC512(jwtSecret.getBytes()));
    }

    public String getEmailFromToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getSubject();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC512(jwtSecret.getBytes())).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
