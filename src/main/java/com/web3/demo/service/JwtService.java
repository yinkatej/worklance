package com.web3.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    static final long EXPIRATION_TIME = 86400000;
    static final String PREFIX = "BEARER";

    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(String username){
        String token = Jwts.builder()
                .setSubject(username).
                setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(key)
                .compact();
        return token;
    }
    public String getAuthUser(HttpServletRequest request){
        String token = String.valueOf(request.getHeaders(HttpHeaders.AUTHORIZATION));
        if (token != null){
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) return user;
        }
        return null;
    }
}
