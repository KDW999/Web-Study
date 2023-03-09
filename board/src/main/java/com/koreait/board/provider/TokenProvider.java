package com.koreait.board.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
    
    public String create(){
        Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt =  Jwts  
                     .builder() //? Jwts Class를 이용해서 JWT 빌드 (생성)
                     .signWith(SignatureAlgorithm.HS256, "SecureKey") //? 암호화 알고리즘, 암호화 키
                     .setSubject("id") //? jwt sub의 값 지정
                     .setIssuedAt(new Date()) //? jwt iat의 값 지정 (생성 시간)
                     .setExpiration(expireDate) //? jwt exp의 값 지정 (만료 시간)
                     .compact(); //? 암호화 알고리즘과 암호화 키를 이용해서 지정한 값들을 토큰으로 변형

        return jwt;
    }
}
