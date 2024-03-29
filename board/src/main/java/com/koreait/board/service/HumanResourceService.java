package com.koreait.board.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.humanResource.PatchHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PatchHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;


@Service
public class HumanResourceService {

    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto) {
        
        PostHumanResourceResponseDto data = null;

        String telNumber = dto.getTelNumber();
        String departmentCode = dto.getDepartment();

        //@ 검증
        try {
            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail(ResponseMessage.EXIST_TELEPHONE_NUMBER);

            if(departmentCode != null){
                boolean hasDepartment = departmentRepository.existsById(departmentCode);
                if( !hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);
            }

            EmployeeEntity employeeEntity = new EmployeeEntity(dto);
            employeeRepository.save(employeeEntity);

            data = new PostHumanResourceResponseDto();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }
        
       
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(int employeeNumber){

        GetHumanResourceResponseDto data = null;

        try{
        //    boolean hasEmployee = employeeRepository.existsById(employeeNumber); // 이건 DB에 2번 접근
        //    if(!hasEmployee) return ResponseDto.setFail("존재 X"); // employeeNumber가 있는지에 대한 검사
        //    EmployeeEntity employeeEntity = employeeRepository.findById(employeeNumber).get();

        // 이건 DB 1번 접근
          EmployeeEntity employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber);
          if(employeeEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

          data = new GetHumanResourceResponseDto(employeeEntity);

        } catch (Exception exception){
           exception.printStackTrace();
           return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<PatchHumanResourceResponseDto> patchHumanResource(PatchHumanResourceRequestDto dto){
        
        PatchHumanResourceResponseDto data = null;

        int employeeNumber = dto.getEmployeeNumber();
        String departmentCode = dto.getDepartment();

        try{

            boolean hasEmployee = employeeRepository.existsById(employeeNumber); // patch에 적어둔 사원 번호가 있는지
            if(!hasEmployee) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            if(departmentCode != null){
            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if(!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);
            }
            
            EmployeeEntity employeeEntity = new EmployeeEntity(dto);
            employeeRepository.save(employeeEntity);

            data = new PatchHumanResourceResponseDto(employeeEntity);

        }catch(Exception e){
          e.printStackTrace();
          return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}