package com.kdw.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kdw.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

    public boolean existsByEmail(String email);
    public boolean existsByTelNumber(String telNumber);
    public boolean existsByNickname(String nickname);

    //? 위 3개의 검증을 한 번에 처리하는 메서드, 셋 중 하나라도 틀리면 false, DB에 한 번 접근 
    //? 단 위에 방법은 뭐가 틀렸는지 정확히 알 수 있다.
    public boolean existsByEmailOrNicknameOrTelNumber(String email, String telNumber, String nickname);

    public UserEntity findByEmail(String email);

    
}
