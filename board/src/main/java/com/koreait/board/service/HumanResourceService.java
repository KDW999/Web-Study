package com.koreait.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.repository.EmployeeRepository;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.repository.DepartmentRepository;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(postHumanResourceRequestDto){

        String telNumber = dto.getTelNumber();

        //@ 동일한 전화번호가 있는지 검증
        try {
            boolean hasTelNumber = employeeRepository.existByIdTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFail("Existed Telephone Number");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail("Database Error");
        }
        PostHumanResourceResponseDto data = new PostHumanResourceResponseDto();

    }
}
