package com.koreait.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.entity.ExampleEntity;


//# @Repository
//? 해당 인터페이스를 Repository로 사용하도록 지정하는 어노테이션
@Repository
//# JpaRepository<T, ID> : 해당 인터페이스를 상속받은 인터페이스를 
//? JPA Query Creation을 사용할 수 있도록 하는 인터페이스
//? T : DB의 테이블을 구현한 Entity Class
//? ID : 해당 Entity Primary Key의 타입
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {
   
    //? 추상메서드로 쿼리 실행문을 작성할 수 있음
    //? 메서드명을 규칙에 따라 작성하게되면 JpaRepository가 알아서 SQL을 작성하고 실행
    public ExampleEntity findByComment(String comment);
}
