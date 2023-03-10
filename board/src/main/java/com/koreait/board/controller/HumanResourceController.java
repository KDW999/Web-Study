package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.humanResource.PatchHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PatchHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.service.HumanResourceService;

@RestController
@RequestMapping(ApiMappingPattern.HR) // 리터럴이 코드 내에 있는 건 좋지 않다??
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;

    private static final String POST_HUMAN_RESOURCE =  "/";
    private static final String GET_HUMAN_RESOURCE = "/{employeeNumber}";
    private static final String PATCH_HUMAN_RESOURCE = "/";

    @PostMapping(POST_HUMAN_RESOURCE)
    //? POST : http://localhost:4040/apis/hr/
    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(@Valid @RequestBody PostHumanResourceRequestDto requestBody) {
        ResponseDto<PostHumanResourceResponseDto> response = humanResourceService.postHumanResource(requestBody);
        return response;
    }

    @GetMapping(GET_HUMAN_RESOURCE) // Get방식이라 path로 받아오기
    //? GET http://localhost:4040/apis/hr/사번
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(@AuthenticationPrincipal String sub, @PathVariable("employeeNumber") int employeeNumber){
        System.out.println("sub : " + sub);
        ResponseDto<GetHumanResourceResponseDto> response = humanResourceService.getHumanResource(employeeNumber);
        return response;
    }

    @PatchMapping(PATCH_HUMAN_RESOURCE)
    //? PATCH http://localhost:4040/apis/hr/
     public ResponseDto<PatchHumanResourceResponseDto> patchHumanResource(@Valid @RequestBody PatchHumanResourceRequestDto requestBody){
        ResponseDto<PatchHumanResourceResponseDto> response = humanResourceService.patchHumanResource(requestBody);
        return response;
     }
}

