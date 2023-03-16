package com.kdw.board.repository;

import com.kdw.board.entity.BoardEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
    public List<BoardEntity> findByWriterEmailOrderByBoardWriteDatetimeDesc(String writerEmail);
    public List<BoardEntity> findByOrderByBoardWriteDatetimeDesc();
    public BoardEntity findByBoardNumber(int boardNumber);
}
