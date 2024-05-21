package org.example.springlab.controllers;

import org.example.springlab.entities.Teacher;
import org.example.springlab.utils.pojos.CreateOrUpdateTeacherPojo;
import org.example.springlab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Long> saveTeacher(@RequestBody CreateOrUpdateTeacherPojo pojo) {
        return new ResponseEntity<>(teacherService.saveTeacher(pojo), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") long id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers() {
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateTeacher(@PathVariable("id") long id, @RequestBody CreateOrUpdateTeacherPojo pojo) {
        teacherService.updateTeacher(id, pojo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTeacherById(@PathVariable("id") long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTeachers() {
        teacherService.deleteTeachers();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
