package com.kdw.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.kdw.board.entity.resultSet.RelatedSearchWordResultSet;
import com.kdw.board.entity.resultSet.SearchWordResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop15RelatedSearchWordResponseDto {
    
    private List<String> top15SearchWordList;

    public static GetTop15RelatedSearchWordResponseDto copyList(List<RelatedSearchWordResultSet> list){

        List<String> result = new ArrayList<>();
        for(RelatedSearchWordResultSet item : list){
            result.add(item.getPreviousSearchWord()); // 단어 넣기
        }
        return new GetTop15RelatedSearchWordResponseDto(result);
        
    }
}
