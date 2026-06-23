package com.edusignal.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey getSigninKey() {
        byte[] keyBytes = secretKey.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Integer userId){
        return Jwts.builder()
                .subject(String.valueOf(userId))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigninKey())
                .compact();
    }

    public Integer extractUserId(String token) {
        String subject = Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        return Integer.valueOf(subject);
    }

    public boolean isTokenValid(String token, Integer userId) {
        Integer extractedId = extractUserId(token);
        return extractedId.equals(userId) &&
                !Jwts.parser()
                        .verifyWith(getSigninKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload()
                        .getExpiration()
                        .before(new Date());
    }

}
