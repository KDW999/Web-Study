package com.kdw.board.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회원가입 Request Body")
@Data
@NoArgsConstructor
public class SignUpDto {

    @ApiModelProperty(value = "User Email", example = "qwer@qwer.com", required = true)
    @NotBlank
    @Email
    @Length(max = 45)
    private String email;

    @ApiModelProperty(value = "User Password", example =  "P!ssw0rd", required = true)
    @NotBlank
    @Length(min = 8, max = 20)
    private String password;

    @ApiModelProperty(value = "User Nickname", example =  "KDW", required = true)
    @NotBlank
    @Length(min = 3, max = 20)
    private String nickname;

    @ApiModelProperty(value = "User TelNumber", example =  "010-4343-2323", required = true)
    @NotBlank
    @Length(min = 11, max = 13)
    private String telNumber;

    @ApiModelProperty(value = "User Address", example = "Busan Busan-Jingu", required = true)
    @NotBlank
    private String address;
}
