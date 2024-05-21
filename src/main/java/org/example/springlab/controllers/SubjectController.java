package org.example.springlab.controllers;

import org.example.springlab.entities.Subject;
import org.example.springlab.utils.pojos.CreateSubjectPojo;
import org.example.springlab.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Long> saveSubject(@RequestBody CreateSubjectPojo pojo) {
        return new ResponseEntity<>(subjectService.saveSubject(pojo.getName()), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") long id) {
        return new ResponseEntity<>(subjectService.getSubjectById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects() {
        return new ResponseEntity<>(subjectService.getSubjects(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateSubject(@PathVariable("id") long id, @RequestBody String name) {
        subjectService.updateSubject(id, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteSubjectById(@PathVariable("id") long id) {
        subjectService.deleteSubjectById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteSubjects() {
        subjectService.deleteSubjects();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
