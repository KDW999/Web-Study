package com.kdw.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdw.board.common.constant.ResponseMessage;
import com.kdw.board.dto.request.board.PostboardDto;
import com.kdw.board.dto.response.ResponseDto;
import com.kdw.board.dto.response.board.PostBoardResponseDto;
import com.kdw.board.entity.BoardEntity;
import com.kdw.board.entity.UserEntity;
import com.kdw.board.repository.BoardRepository;
import com.kdw.board.repository.UserRepository;

@Service
public class BoardService {
    
    @Autowired private BoardRepository boardRepository;
    @Autowired private UserRepository userRepository;

    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostboardDto dto){
       
        PostBoardResponseDto data = null;

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = new BoardEntity(userEntity, dto);
            boardRepository.save(boardEntity);

            data = new PostBoardResponseDto(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}
