package com.dcodetech.ATMMACHINE;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

@Service
public class JwtTokenProvider {

    @Value("${jwt.expiration}") //application.properties madhun time set hoel 60mins variable la ithe
    private long expiration;

    // Use the Keys class to generate a secure key for HS512
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = Date.from(Instant.now().plus(expiration, ChronoUnit.MINUTES));

        return Jwts.builder()
                .claim("username", username)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
}
