package com.kdw.board.dto.response.auth;

import com.kdw.board.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인
// 회원가입으로 만든 이메일과 패스워드 입력해주고 있으면 유저의 정보와 토큰 발행
@ApiModel(value = "로그인 Response Body - Data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    @ApiModelProperty(value = "사용자 이메일", example = "hide4321@naver.com", required = true)
    private String email;

    @ApiModelProperty(value = "사용자 닉네임", example = "KDW", required = true)
    private String nickname;

    @ApiModelProperty(value = "사용자 휴대폰 번호", example = "010-7676-2323", required = true)
    private String telNumber;

    @ApiModelProperty(value = "사용자 주소", example = "부산광역시 부산진구", required = true)
    private String address;

    @ApiModelProperty(value = "사용자 프로필 사진 URL", example = "http://~", required = true)
    private String profile;

    @ApiModelProperty(value = "JWT 토큰", example = "asfsdg234234", required = true)
    private String token;

    @ApiModelProperty(value = "토큰 만료 기간", example = "3600000", required = true)
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
