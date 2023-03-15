package com.kdw.board.dto.response.auth;

import com.kdw.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 회원가입
// 유저에 대한 정보 입력
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto {

    private boolean status;
    
}
