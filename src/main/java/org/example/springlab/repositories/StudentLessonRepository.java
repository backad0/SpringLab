package org.example.springlab.repositories;

import org.example.springlab.entities.Lesson;
import org.example.springlab.entities.Student;
import org.example.springlab.utils.rowMappers.LessonRowMapper;
import org.example.springlab.utils.rowMappers.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

@Repository
public class StudentLessonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper;
    private final LessonRowMapper lessonRowMapper;

    @Autowired
    public StudentLessonRepository(JdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper, LessonRowMapper lessonRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
        this.lessonRowMapper = lessonRowMapper;
    }

    @Transactional
    public void saveStudentOnLessons(long studentId, List<Long> lessonsIds) {
        jdbcTemplate.batchUpdate(
                "insert into StudentLesson (student_id, lesson_id) values (?, ?)",
                lessonsIds,
                lessonsIds.size(),
                (PreparedStatement ps, Long lessonId) -> {
                    ps.setLong(1, studentId);
                    ps.setLong(2, lessonId);
                }
        );
    }

    @Transactional
    public void saveLessonOnStudents(long lessonId, List<Long> studentsIds) {
        jdbcTemplate.batchUpdate(
                "insert into StudentLesson (student_id, lesson_id) values (?, ?)",
                studentsIds,
                studentsIds.size(),
                (PreparedStatement ps, Long studentId) -> {
                    ps.setLong(1, studentId);
                    ps.setLong(2, lessonId);
                }
        );
    }

    public List<Student> getStudentsByLesson(long lessonId) {
        return jdbcTemplate.query(
                "select s.* from studentLesson sl join student s on s.id = sl.student_id where sl.lesson_id = ?",
                new Object[]{lessonId},
                new int[]{Types.BIGINT},
                new StudentRowMapper()
        );
    }
}
