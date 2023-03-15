package com.kdw.board.dto.response.auth;

import com.kdw.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인
// 회원가입으로 만든 이메일과 패스워드 입력해주고 있으면 유저의 정보와 토큰 발행
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    private String email;
    private String nickname;
    private String telNumber;
    private String address;
    private String profile;
    private String token;
    private int expiredTime;

    public SignInResponseDto(UserEntity userEntity, String token){
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.telNumber = userEntity.getTelNumber();
        this.address = userEntity.getAddress();
        this.profile = userEntity.getProfile();
        this.token = token;
        this.expiredTime = 3600000;
    }
}