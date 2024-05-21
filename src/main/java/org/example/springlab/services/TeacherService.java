package org.example.springlab.services;

import org.example.springlab.entities.Teacher;
import org.example.springlab.utils.pojos.CreateOrUpdateTeacherPojo;
import org.example.springlab.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public long saveTeacher(CreateOrUpdateTeacherPojo pojo) {
        return teacherRepository.saveTeacher(pojo);
    }

    public Teacher getTeacherById(long id) {
        return teacherRepository.getTeacherById(id);
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.getTeachers();
    }

    public void updateTeacher(long id, CreateOrUpdateTeacherPojo pojo) {
        teacherRepository.updateTeacher(id, pojo);
    }

    public void deleteTeacherById(long id) {
        teacherRepository.deleteTeacherById(id);
    }

    public void deleteTeachers() {
        teacherRepository.deleteTeacher();
    }
}
