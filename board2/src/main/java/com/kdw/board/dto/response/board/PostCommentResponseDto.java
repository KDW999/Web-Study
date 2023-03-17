package com.kdw.board.dto.response.board;

import java.util.List;

import com.kdw.board.entity.BoardEntity;
import com.kdw.board.entity.CommentEntity;
import com.kdw.board.entity.LikyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentResponseDto {
    private BoardEntity board;
    private List<LikyEntity> likeList;
    private List<CommentEntity> commentList;
}
