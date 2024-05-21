package org.example.springlab.utils.rowMappers;

import org.example.springlab.entities.Lesson;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

@Component
public class LessonRowMapper implements RowMapper<Lesson> {
    @Override
    public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        Date date = rs.getDate("date");
        Time time = rs.getTime("time");
        long teacherId = rs.getLong("teacher_id");
        long groupId = rs.getLong("group_id");
        long subjectId = rs.getLong("subject_id");
        return new Lesson(id, date, time, teacherId, groupId, subjectId);
    }
}
