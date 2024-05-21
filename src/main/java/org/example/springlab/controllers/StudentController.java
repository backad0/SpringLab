package org.example.springlab.controllers;

import org.example.springlab.entities.Lesson;
import org.example.springlab.entities.Student;
import org.example.springlab.utils.pojos.CreateOrUpdateStudentPojo;
import org.example.springlab.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Long> saveStudent(@RequestBody CreateOrUpdateStudentPojo pojo) {
        return new ResponseEntity<>(studentService.saveStudent(pojo), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateStudent(@PathVariable("id") long id, @RequestBody CreateOrUpdateStudentPojo pojo) {
        studentService.updateStudent(id, pojo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteStudents() {
        studentService.deleteStudents();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
