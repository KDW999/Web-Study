package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employee")
@Table(name = "Employee")

public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public EmployeeEntity(PostHumanResourceRequestDto dto){
          this.position = dto.getPosition();
          this.name = dto.getName();
          this.age = dto.getAge();
          this.gender = dto.getGender();
          this.academicAbility = dto.getAcademicAbility();
          this.birth = dto.getBirth();
          this.telNumber = dto.getTelNumber();
          this.address = dto.getAddress();
          this.addressDetail = dto.getAddressDetail();
          this.joinDate = dto.getJoinDate();
          this.resignationDate = dto.getResignationDate();
          this.department = dto.getDepartment();
          this.annualIncome = dto.getAnnualIncome();
          this.note = dto.getNote();
    };
}
