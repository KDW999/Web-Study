package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.koreait.board.dto.request.department.PostDepartmentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Department")
@Table(name = "Department")

public class DepartmentEntity {
      @Id
      private String departmentCode; //? 부서코드
      private String name; //? 부서명
      private int chief; //? 부서장 사번
      private String telNumber; //? 부서 전화번호

      public DepartmentEntity(PostDepartmentRequestDto dto){
           this.departmentCode = dto.getDepartmentCode();
           this.name = dto.getName();
           this.chief = dto.getChief();
           this.telNumber = dto.getTelNumber();
      }
}
