package org.example.springlab.services;

import org.example.springlab.entities.Lesson;
import org.example.springlab.utils.pojos.CreateOrUpdateLessonPojo;
import org.example.springlab.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public long saveLesson(CreateOrUpdateLessonPojo pojo) {
        return lessonRepository.saveLesson(pojo);
    }

    public Lesson getLessonById(long id) {
        return lessonRepository.getLessonById(id);
    }

    public List<Lesson> getLessons() {
        return lessonRepository.getLessons();
    }

    public void updateLesson(long id, CreateOrUpdateLessonPojo pojo) {
        lessonRepository.updateLesson(id, pojo);
    }

    public void deleteLessonById(long id) {
        lessonRepository.deleteLessonById(id);
    }

    public void deleteLessons() {
        lessonRepository.deleteLessons();
    }
}
