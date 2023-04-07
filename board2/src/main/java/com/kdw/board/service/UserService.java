package com.kdw.board.service;

import com.kdw.board.dto.request.user.PatchProfileDto;
import com.kdw.board.dto.request.user.ValidateEmailDto;
import com.kdw.board.dto.request.user.ValidateNicknameDto;
import com.kdw.board.dto.request.user.ValidateTelNumberDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.user.GetUserResponseDto;
import com.kdw.board.dto.response.user.PatchProfileResponseDto;
import com.kdw.board.dto.response.user.ValidateEmailResponseDto;
import com.kdw.board.dto.response.user.ValidateNicknameResponseDto;
import com.kdw.board.dto.response.user.ValidateTelNumberResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto);
    public ResponseDto<GetUserResponseDto> getUser(String email);
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto);
    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto);
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto);
}
