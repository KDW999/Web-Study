package com.kdw.board.repository;

import com.kdw.board.entity.BoardEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
}
