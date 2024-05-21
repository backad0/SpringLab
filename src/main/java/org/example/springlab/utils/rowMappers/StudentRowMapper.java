package org.example.springlab.utils.rowMappers;

import org.example.springlab.entities.Lesson;
import org.example.springlab.entities.Student;
import org.example.springlab.enums.StudentStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String firstName = rs.getString("firstName");
        String surname = rs.getString("surname");
        String secondName = rs.getString("secondName");
        StudentStatus status = StudentStatus.valueOf(rs.getString("status"));
        long groupId = rs.getLong("group_id");
        return new Student(id, firstName, surname, secondName, status, groupId);
    }
}
