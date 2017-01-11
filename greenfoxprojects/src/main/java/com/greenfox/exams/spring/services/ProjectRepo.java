package com.greenfox.exams.spring.services;

import com.greenfox.exams.spring.models.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by regnisalram on 1/11/17.
 */
public interface ProjectRepo extends CrudRepository <Project, Long> {
}
