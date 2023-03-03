package com.koreait.board.entity;

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
@Entity(name = "Entity")
@Table(name = "Entity")
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prime;
    private String comment;
    private int number;
}
