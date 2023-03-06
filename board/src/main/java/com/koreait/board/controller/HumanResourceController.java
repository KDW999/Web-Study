package com.koreait.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.service.HumanResourceService;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;

@RestController
@RequestMapping("/apis/hr")
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;

    @PostMapping("/")
    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(@Valid @RequestBody PostHumanResuourceRequestDto requestBody){
          
          ResponseDto<PostHumanResourceResponseDto> response = humanResourceService.postHumanResource(requestBody);

          return ResponseDto.setSuccess("Success", data);
    }
}
