package com.koreait.board.dto.request.department;

import java.util.*;

import com.koreait.board.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllDepartmentListResponseDto {
      private String departmentCode; //? 부서코드
      private String name; //? 부서명
      private int chief; //? 부서장 사번
      private String telNumber; //? 부서장 전화번호

      public GetAllDepartmentListResponseDto(DepartmentEntity departmentEntity){
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.chief = departmentEntity.getChief();
        this.telNumber = departmentEntity.getTelNumber();
      }

      public static List<GetAllDepartmentListResponseDto> copyList(List<DepartmentEntity> departmentEntities){

        List<GetAllDepartmentListResponseDto> result = new ArrayList<GetAllDepartmentListResponseDto>();

        for (DepartmentEntity departmentEntity: departmentEntities) {
            GetAllDepartmentListResponseDto item = new GetAllDepartmentListResponseDto(departmentEntity);
            result.add(item);
        }
             return result;
      }
}
