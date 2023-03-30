package com.kdw.board.service.implementation;

import javax.sound.midi.Patch;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdw.board.common.constant.ResponseMessage;
import com.kdw.board.dto.request.user.PatchProfileDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.user.GetUserResponseDto;
import com.kdw.board.dto.response.user.PatchProfileResponseDto;
import com.kdw.board.entity.UserEntity;
import com.kdw.board.repository.UserRepository;
import com.kdw.board.service.UserService;

@Service
public class UserServiceImplements implements UserService {

    @Autowired private UserRepository userRepository;

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

    
}
