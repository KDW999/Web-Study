package com.kdw.board.controller;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdw.board.common.constant.ApiPattern;
import com.kdw.board.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kdw.board.dto.request.auth.SignInDto;
import com.kdw.board.dto.request.auth.SignUpDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.auth.SignInResponseDto;
import com.kdw.board.dto.response.auth.SignUpResponseDto;

@RestController
@RequestMapping(ApiPattern.AUTH)
@Api(description = "인증 모듈")
public class AuthController {
    
    @Autowired private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @ApiOperation(value = "회원가입", notes = "이메일, 비밀번호, 닉네임, 전화번호, 주소를 입력하여 회원을 등록하고 성공 시에는 회원가입 성공 여부에 true가 반환")
    @PostMapping(SIGN_UP) // auth와 관련된 건 웬만하면 다 POST, CRUD의 C, 데이터 숨겨줘야함
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto requestBody) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping(SIGN_IN)
    public ResponseDto<SignInResponseDto> signIn(@Valid @RequestBody SignInDto requestBody ){
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
