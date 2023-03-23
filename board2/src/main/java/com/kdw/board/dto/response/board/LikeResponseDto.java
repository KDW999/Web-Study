package com.kdw.board.dto.response.board;

import java.util.List;

import com.kdw.board.entity.BoardEntity;
import com.kdw.board.entity.CommentEntity;
import com.kdw.board.entity.LikyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "좋아요 기능 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDto {

    @ApiModelProperty(value = "게시물 Entity", required = true)
    private BoardEntity board;

    @ApiModelProperty(value = "조항요 Entity List", required = true)
    private List<LikyEntity> likeList;

    @ApiModelProperty(value = "댓글 Entity List", required = true)
    private List<CommentEntity> commentList;
}
