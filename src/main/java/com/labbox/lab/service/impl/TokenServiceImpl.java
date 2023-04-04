package com.labbox.lab.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.labbox.lab.entities.User;
import com.labbox.lab.exception.CustomException;
import com.labbox.lab.exception.ErrorCustom;
import com.labbox.lab.model.TokenModel;
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
    public TokenModel generateToken(User user) {

        Date exp = Date.from(LocalDateTime.now()
                .plusSeconds(30)
                .toInstant(ZoneOffset.of("-04:00")));

        var currentToken = JWT.create()
                .withIssuer("lab")
                .withSubject(user.getUsername())
                .withClaim("id", user.getUserId())
                .withExpiresAt(exp)
                .sign(Algorithm.HMAC256(secret));

        return new TokenModel(currentToken, exp.toString(), user.getUsername());
    }

    @Override
    public String getSubject(String token) {

            return JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("lab")
                    .build().verify(token)
                    .getSubject();

    }
}
