package com.kdw.board.service.implementation;

import javax.sound.midi.Patch;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdw.board.common.constant.ResponseMessage;
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
import com.kdw.board.entity.UserEntity;
import com.kdw.board.repository.UserRepository;
import com.kdw.board.service.UserService;

@Service
public class UserServiceImplements implements UserService {
    
    @Autowired private UserRepository userRepository;
    
    //? 유저 조회
    public ResponseDto<GetUserResponseDto> getUser(String email) {
       
        GetUserResponseDto data = null;
    
        try {
    
            UserEntity userEntity = userRepository.findByEmail(email);
    
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);
    
            data = new GetUserResponseDto(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
    //? 이메일 검증
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto) {
        
        ValidateEmailResponseDto data = null;
        String email = dto.getEmail();

        try {

            boolean hasEmail = userRepository.existsByEmail(email);
            data = new ValidateEmailResponseDto(hasEmail);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    //? 닉네임 검증
    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto) {

        ValidateNicknameResponseDto data = null;
        String nickname = dto.getNickname();
        
        try {
            
            boolean hasNickname = userRepository.existsByNickname(nickname);
            data = new ValidateNicknameResponseDto(hasNickname);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
    //? 전화번호 검증
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto) {

        ValidateTelNumberResponseDto data = null;
        String telNumber = dto.getTelNumber();
        
        try {

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            data = new ValidateTelNumberResponseDto(hasTelNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }
    
    //? 유저 프로필 수정
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto){
    
        PatchProfileResponseDto data = null;
        String profile = dto.getProfile();
    
        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);
    
            userEntity.setProfile(profile);
            userRepository.save(userEntity);
    
            data = new PatchProfileResponseDto(userEntity);
    
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
