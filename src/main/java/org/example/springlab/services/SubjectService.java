package org.example.springlab.services;

import org.example.springlab.entities.Subject;
import org.example.springlab.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public long saveSubject(String name) {
        return subjectRepository.saveSubject(name);
    }

    public Subject getSubjectById(long id) {
        return subjectRepository.getSubjectById(id);
    }

    public List<Subject> getSubjects() {
        return subjectRepository.getSubjects();
    }

    public void updateSubject(long id, String name) {
        subjectRepository.updateSubject(id, name);
    }

    public void deleteSubjectById(long id) {
        subjectRepository.deleteSubjectById(id);
    }

    public void deleteSubjects() {
        subjectRepository.deleteSubject();
    }
}
