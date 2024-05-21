package org.example.springlab.controllers;

import org.example.springlab.entities.Student;
import org.example.springlab.services.StudentLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentLessonController {

    @Autowired
    public StudentLessonService studentLessonService;

    @PostMapping("student/{id}/lessons")
    public ResponseEntity saveStudentOnLessons(@PathVariable("id") long studentId, @RequestBody List<Long> lessonIds) {
        studentLessonService.saveStudentOnLessons(studentId, lessonIds);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("lesson/{id}/students")
    public ResponseEntity saveLessonOnStudents(@PathVariable("id") long lessonId, @RequestBody List<Long> studentIds) {
        studentLessonService.saveLessonOnStudents(lessonId, studentIds);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("lesson/{id}/students")
    public ResponseEntity<List<Student>> getStudentsByLesson(@PathVariable("id") long lessonId) {
        return new ResponseEntity<>(studentLessonService.getStudentsByLesson(lessonId), HttpStatus.OK);
    }
}
