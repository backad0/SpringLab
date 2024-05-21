package org.example.springlab.controllers;

import org.example.springlab.entities.Lesson;
import org.example.springlab.utils.pojos.CreateOrUpdateLessonPojo;
import org.example.springlab.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<Long> saveLesson(@RequestBody CreateOrUpdateLessonPojo pojo) {
        return new ResponseEntity<>(lessonService.saveLesson(pojo), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable long id) {
        return new ResponseEntity<>(lessonService.getLessonById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getLessons(){
        return new ResponseEntity<>(lessonService.getLessons(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateLesson(@PathVariable("id") long id, @RequestBody CreateOrUpdateLessonPojo pojo) {
        lessonService.updateLesson(id, pojo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteLessonById(@PathVariable("id") long id) {
        lessonService.deleteLessonById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteLessons() {
        lessonService.deleteLessons();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
