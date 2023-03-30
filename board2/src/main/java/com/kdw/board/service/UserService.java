package com.kdw.board.service;

import com.kdw.board.dto.request.user.PatchProfileDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.user.GetUserResponseDto;
import com.kdw.board.dto.response.user.PatchProfileResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto);
    public ResponseDto<GetUserResponseDto> getUser(String email);
}
