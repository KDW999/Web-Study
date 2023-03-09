package com.koreait.board.dto.response.department;

import java.util.*;

import com.koreait.board.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDepartmentResponseDto {
    private String departmentCode; //? 부서코드
      private String name; //? 부서명
      private int chief; //? 부서장 사번
      private String telNumber; //? 부서장 전화번호

      public DeleteDepartmentResponseDto(DepartmentEntity departmentEntity){
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.chief = departmentEntity.getChief();
        this.telNumber = departmentEntity.getTelNumber();
      }

      public static List<DeleteDepartmentResponseDto> copyList(List<DepartmentEntity> departmentEntities){

        List<DeleteDepartmentResponseDto> result = new ArrayList<DeleteDepartmentResponseDto>();

        for (DepartmentEntity departmentEntity: departmentEntities) {
            DeleteDepartmentResponseDto item = new DeleteDepartmentResponseDto(departmentEntity);
            result.add(item);
        }
             return result;
      }
}
