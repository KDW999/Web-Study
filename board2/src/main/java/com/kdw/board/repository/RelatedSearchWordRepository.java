package com.kdw.board.repository;

import com.kdw.board.entity.RelatedSearchWordEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RelatedSearchWordRepository extends JpaRepository<RelatedSearchWordEntity, Integer>{
    
}
