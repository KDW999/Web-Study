package com.kdw.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kdw.board.entity.LikyEntity;
import com.kdw.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPk>{
    
    public List<LikyEntity> findByBoardNumber(int boardNumber);
    public LikyEntity findByUserEmailAndBoardNumber(String email, int boardNumber);
}
