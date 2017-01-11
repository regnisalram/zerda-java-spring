package com.greenfox.exams.spring.services;

import com.greenfox.exams.spring.models.Entry;
import com.greenfox.exams.spring.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by regnisalram on 1/11/17.
 */
@Service
public class WelcomeService {

    private DataLoader dataLoader;
    private EntryRepo entryRepository;

    @Autowired
    public WelcomeService(DataLoader dataLoader, EntryRepo entryRepository) {
        this.dataLoader = dataLoader;
        this.entryRepository = entryRepository;
    }

    public Iterable<Project> listProjects() {
        return dataLoader.repo.findAll();
    }

    public void create(String experience, Integer scale, String email) {
        entryRepository.save(new Entry(experience, scale, email));
    }

    public boolean validate(String experience, Integer scale, String email) {
        return (validateExperience(experience)
                && validateScale(scale)
                && validateEmail(email));
    }

    public boolean validateExperience (String experience) {
        String[] niceWords = {"amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"};
        int niceWordCount = 0;

        for (String word : niceWords) {
            if (experience.contains(word)) {
                niceWordCount++;
            }
        }
        return (niceWordCount >= 3);
    }

    private boolean validateScale(Integer scale) {
        return (scale >= 10);
    }

    private boolean validateEmail(String email) {
        return (email.contains("@") && email.contains("."));
    }
}
