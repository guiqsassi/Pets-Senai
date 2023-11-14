package com.example.demo.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.demo.Models.User;

@Service
public class TokenSevice {
    @Value("${api.security.token.secret}")
    private String secret;
    @Value("${api.security.token.issuer}")
    private String issuer;
    @Value("${api.security.token.expiration_min}")
    private String expirationMin;


    public Instant dataExpiracao(){
        return LocalDateTime
        .now()
        .plusMinutes(Long.parseLong(expirationMin))
        .toInstant(ZoneOffset.of("-3:00"));
    } 

    public String gerarToker(UserDetails user){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT
            .create()
            .withIssuer(issuer)
            .withExpiresAt(dataExpiracao())
            .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar toker" + exception);
        }
    }

    public String getSubject(String tokenJWT){

    }
}
