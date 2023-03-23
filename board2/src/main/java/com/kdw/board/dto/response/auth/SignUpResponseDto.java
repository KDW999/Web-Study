package com.kdw.board.dto.response.auth;

import com.kdw.board.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 회원가입
// 유저에 대한 정보 입력
@ApiModel(value = "회원가입 Response Body -")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto {

    @ApiModelProperty(value = "회원가입 결과", example = "true", required = true)
    private boolean status;
    
}
