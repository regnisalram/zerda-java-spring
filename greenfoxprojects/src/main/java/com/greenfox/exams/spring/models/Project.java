package com.greenfox.exams.spring.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by regnisalram on 1/11/17.
 */
@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter (AccessLevel.NONE)
    private Long id;
    private String projectName;
    private String projectTag;

    public Project() {
    }

    public Project(String projectName, String projectTag) {
        this.projectName = projectName;
        this.projectTag = projectTag;
    }
}
