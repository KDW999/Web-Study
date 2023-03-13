package com.kdw.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="SearchWordLog")
@Table(name="SearchWordLog")
public class SearchWordLogEntity {
//     sequence int AI PK 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;
// search_word text

}
