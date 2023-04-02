package com.labbox.lab.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.labbox.lab.entities.User;
import com.labbox.lab.service.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${spring.jwt.secret}")
    private String secret;

    @Value("${spring.jwt.expiration}")
    private String expiration;

    @Override
    public String generateToken(User user) {
        return JWT.create()
                .withIssuer("lab")
                .withSubject(user.getUsername())
                .withClaim("id", user.getUserId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-04:00")))
                ).sign(Algorithm.HMAC256(secret));
    }
}
