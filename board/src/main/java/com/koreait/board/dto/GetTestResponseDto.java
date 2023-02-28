package com.koreait.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 해당 어노테이션들로 생성자, getter, setter, toString 선언을 따로 해줄 필요 X

public class GetTestResponseDto {

	@NonNull
	private int number;
	private String text;
	
}
