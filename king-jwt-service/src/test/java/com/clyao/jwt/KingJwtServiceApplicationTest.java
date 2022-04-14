package com.clyao.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class KingJwtServiceApplicationTest {

    @Test
    public void test(){
        JwtBuilder jwtBuilder= Jwts.builder().setId("123").setSubject("king").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "king");
        String token = jwtBuilder.compact();
        System.out.println(token);
    }

    @Test
    public void test2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiJraW5nIiwiaWF0IjoxNjQ5ODIxNzM4fQ.4TRNd334q6zEZ-GR7BaDsCB6wQPc_0TawfmNc5Nh6K0";
        Claims claims = Jwts.parser().setSigningKey("king").parseClaimsJws(token).getBody();
        System.out.println(claims);
    }

}
