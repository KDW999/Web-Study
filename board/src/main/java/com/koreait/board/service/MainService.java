package com.koreait.board.service;

import org.springframework.stereotype.Service;

import com.koreait.board.dto.PostTestRequestDto;
import com.koreait.board.dto.ResponseDto;
import com.koreait.board.dto.GetTestResponseDto;

//# Service
//? 실제 비즈니스 로직을 담당하는 레이어
//? 일반적인 연산 작업
//? Controller로 부터 사용자의 입력을 받아오면 해당 기능을 진행하기 위해
//? Repository에서 데이터를 가져와 작업을 진행함

@Service
public class MainService {

    public ResponseDto<String> getMain(){
        ResponseDto<String> result = ResponseDto.setSuccess("Success", "Hello World");
        return result;
    }

    public String getVariable(String data){
        return "You input data is '" + data + "'";
    }

    public String postMain(){
        return "Post main Response!";
    }

    public String postRequestBody(String data){
        return "Post body data is "+ data + "'";
    }

    public String patchMain(){
        return "Patch Method는 수정 작업을 지정한 메서드입니다. 클라이언트로 부터 데이터를 받을 땐 request body로 받습니다.";
    }

    public String deleteMain(){
        return "Delete Method는 삭제 작업을 지정한 메서드입니다. 클라이언트로 부터 데이터를 받을 땐 path variable로 받습니다.";
    }

    public String postTest(PostTestRequestDto dto){
        return dto.toString();
    }

    public GetTestResponseDto getTest(){
        return new GetTestResponseDto(10, "Comment");
    }
}
