package com.create.demo.enttiy;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.create.demo.enttiy.primaryKey.LikyPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")


public class LikyEntity {

    @EmbeddedId
    private LikyPK likyPK;
    private String userProfile;
    private String userNickname;
}
