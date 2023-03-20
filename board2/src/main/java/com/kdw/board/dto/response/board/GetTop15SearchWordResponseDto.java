package com.kdw.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.kdw.board.entity.resultSet.SearchWordResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop15SearchWordResponseDto {
    
    private List<String> top15SearchWordList;

    public static GetTop15SearchWordResponseDto copyList(List<SearchWordResultSet> list){

        List<String> result = new ArrayList<>();
        for(SearchWordResultSet item : list){
            result.add(item.getSearchWord()); // 단어 넣기
        }
        return new GetTop15SearchWordResponseDto(result);
        
    }
}
