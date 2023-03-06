package com.koreait.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto) {
        
        String telNumber = dto.getTelNumber();

        //@ 동일한 전화번호 검증
        try {
            boolean hasTelNumber = employeeRepository.existByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail("Existed Telephone Number");
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail("Database Error");
        }
        
        PostHumanResourceResponseDto data = new PostHumanResourceResponseDto();
        return ResponseDto.setSuccess("Success", data);
    }

}