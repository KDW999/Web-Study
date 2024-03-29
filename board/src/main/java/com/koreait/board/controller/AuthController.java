package com.koreait.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.provider.TokenProvider;

@RestController
@RequestMapping(ApiMappingPattern.AUTH)
public class AuthController {
    
    @Autowired private TokenProvider tokenProvider;

    private static final String GET_TOKEN = "/getToken";
    private static final String VALIDATE_TOKEN = "/validateToken";

    @PostMapping(GET_TOKEN)
    public String getToken(){
        return tokenProvider.create();
    }

    @PostMapping(VALIDATE_TOKEN)
    public String validateToken(@RequestBody String requestBody){
        return tokenProvider.validate(requestBody);
    }
}
