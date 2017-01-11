package com.greenfox.exams.spring.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by regnisalram on 1/11/17.
 */
@Entity
@Getter
@Setter
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String experience;

    private Integer scale;

    private String email;


    public Entry() {
    }

    public Entry(String experience, Integer scale, String email) {
        this.experience = experience;
        this.scale = scale;
        this.email = email;
    }
}
