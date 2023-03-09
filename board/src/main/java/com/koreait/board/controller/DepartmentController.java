package com.koreait.board.controller;

import javax.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.department.GetAllDepartmentListResponseDto;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.PostDepartmentResponseDto;
import com.koreait.board.service.DepartmentService;
import com.koreait.board.dto.response.department.DeleteDepartmentResponseDto;;

@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT) // 연결 URL
public class DepartmentController {
    
    @Autowired DepartmentService departmentService; // 인스턴스 생성 작업을 스프링에게 맡김
     private static final String POST_DEPARTMENT = "/";
     private static final String GET_ALL_DEPARTMENT_LIST = "/all";
     private static final String DELETE_DEPARTMENT = "/{departmentCode}";
    
    @PostMapping(POST_DEPARTMENT)
    //? POST http://localhost:4040/apis/department/
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto reqeustBody){
        ResponseDto<PostDepartmentResponseDto> response = departmentService.postDepartment(reqeustBody);
        return response;
        // postman에서 값 볼려면 postDepartmentRequestDto에 있는 값들을 postman body-raw-json에 적어줘야함
    }

    @GetMapping(GET_ALL_DEPARTMENT_LIST)
    //? GET http://localhost:4040/apis/department/all
    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList(){
        ResponseDto<List<GetAllDepartmentListResponseDto>> response = departmentService.getAllDepartmentList();
        return response;
    }

    
    @DeleteMapping(DELETE_DEPARTMENT)
    //? DELETE http://localhost:4040/apis/department/{departmentCode}
    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(@PathVariable("departmentCode") String departmentCode){
        ResponseDto<List<DeleteDepartmentResponseDto>> response = departmentService.deleteDepartment(departmentCode);
        return response;
    }
}
