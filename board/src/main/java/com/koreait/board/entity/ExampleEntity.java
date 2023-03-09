package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//# @Entity(name = "Entity명") : DB 테이블에 상응하는 Entity class를 지정해주는 어노테이션
//? ORM이 해당 어노테이션으로 작성된 class를 특정 테이블에 매핑되도록 함
//# @Table(name = "Table명") : 해당 Entity의 테이블명을 지정하기 위한 어노테이션
//? @Table을 추가하지 않으면 @Entity의 Entity명을 따라 테이블명을 지정
//# @Builder : Builder 패턴을 생성해주는 lombok 어노테이션
//? Builder 패턴 : 생성자로 특정한 필드를 지정해서 지정된 필드들만 초기화 하는 것이 아닌 생성하는 순간에 초기화할 필드를 지정해서
//?                인스턴스를 생성해주는 패턴
//? 사용방법 : 클래스명.builder().필드명(초기화할 데이터)[...].build();
@Data //^ getter, setter, toString()
@Builder
@NoArgsConstructor //^ 빈 생성자
@AllArgsConstructor //^ 완성형 생성자
@Entity(name = "Example")
@Table(name = "Example")
public class ExampleEntity {
    //# @Id : 해당 필드를 Primary Key로 지정
    @Id
    //# @GeneratedValue(...) : 필드의 값을 자동으로 생성해주기 위한 어노테이션
    //# strategy = GenerationType.IDENTITY : AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prime;
    private String comment;
    private int number;
}
