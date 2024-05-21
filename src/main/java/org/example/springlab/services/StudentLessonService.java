package org.example.springlab.services;

import org.example.springlab.entities.Lesson;
import org.example.springlab.entities.Student;
import org.example.springlab.repositories.StudentLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLessonService {

    @Autowired
    private StudentLessonRepository studentLessonRepository;

    public void saveStudentOnLessons(long studentId, List<Long> lessonIds) {
        studentLessonRepository.saveStudentOnLessons(studentId, lessonIds);
    }

    public void saveLessonOnStudents(long lessonId, List<Long> studentsIds) {
        studentLessonRepository.saveLessonOnStudents(lessonId, studentsIds);
    }

    public List<Student> getStudentsByLesson(long lessonId) {
        return studentLessonRepository.getStudentsByLesson(lessonId);
    }
}
