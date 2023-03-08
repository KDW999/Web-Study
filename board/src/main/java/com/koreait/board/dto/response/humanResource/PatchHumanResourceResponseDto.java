package com.koreait.board.dto.response.humanResource;

import com.koreait.board.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchHumanResourceResponseDto {
    private int employeeNumber; //? 사번
    private String position; //? 직급
    private String name; //? 이름
    private int age; //? 나이
    private String gender; //? 성별
    private String academicAbility; //? 학력
    private String birth; //? 생년월일
    private String telNumber; //? 휴대 전화번호
    private String address; //? 주소
    private String addressDetail; //? 상세 주소
    private String joinDate; //? 입사일
    private String resignationDate; //? 퇴사일
    private String department; //? 부서 코드
    private int annualIncome; //? 연봉
    private String note; //? 비고

    public PatchHumanResourceResponseDto(EmployeeEntity employeeEntity){
        this.employeeNumber = employeeEntity.getEmployeeNumber();
          this.position = employeeEntity.getPosition();
          this.name = employeeEntity.getName();
          this.age = employeeEntity.getAge();
          this.gender = employeeEntity.getGender();
          this.academicAbility = employeeEntity.getAcademicAbility();
          this.birth = employeeEntity.getBirth();
          this.telNumber = employeeEntity.getTelNumber();
          this.address = employeeEntity.getAddress();
          this.addressDetail = employeeEntity.getAddressDetail();
          this.joinDate = employeeEntity.getJoinDate();
          this.resignationDate = employeeEntity.getResignationDate();
          this.department = employeeEntity.getDepartment();
          this.annualIncome = employeeEntity.getAnnualIncome();
          this.note = employeeEntity.getNote();
    }
}
