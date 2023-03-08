package com.koreait.board.dto.request.humanResource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchHumanResourceRequestDto {
    
    @Min(1)
    private int employeeNumber; //? 사번
    
    @NotBlank
    @Length(min=0, max=5)
    private String position; //? 직급

    @NotBlank
    @Length(min=0, max=10)
    private String name; //? 이름

    @Range(min=0, max=120)
    private int age; //? 나이

    @NotBlank
    @Length(min=0, max=5)
    private String gender; //? 성별

    @NotBlank
    @Length(min=0, max=10)
    private String academicAbility; //? 학력

    @NotBlank
    private String birth; //? 생년월일

    @NotBlank
    private String telNumber; //? 휴대 전화번호

    @NotBlank
    private String address; //? 주소

    @NotBlank
    private String addressDetail; //? 상세 주소

    @NotBlank
    private String joinDate; //? 입사일

    private String resignationDate; //? 퇴사일

    private String department; //? 부서 코드

    @Min(0)
    private int annualIncome; //? 연봉

    private String note; //? 비고
}
