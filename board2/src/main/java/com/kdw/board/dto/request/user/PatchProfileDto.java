package com.kdw.board.dto.request.user;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchProfileDto {
    
    @NotBlank
    @URL
    private String profile;
}
