package com.kdw.board.service;

import com.kdw.board.dto.request.auth.SignInDto;
import com.kdw.board.dto.request.auth.SignUpDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.auth.SignInResponseDto;
import com.kdw.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
}