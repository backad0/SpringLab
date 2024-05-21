package org.example.springlab.repositories;

import org.example.springlab.entities.Subject;
import org.example.springlab.exceprions.MyDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
public class SubjectRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Subject> subjectRowMapper;

    @Autowired
    public SubjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.subjectRowMapper = (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("subjectName");
            return new Subject(id, name);
        };
    }

    public long saveSubject(String name) {
        String sql = "insert into Subject (subjectName) values (?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, name);
            return preparedStatement;
        };
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    public Subject getSubjectById(long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from Subject where id = ?",
                    new Object[]{id},
                    new int[]{Types.BIGINT},
                    subjectRowMapper);
        } catch (DataAccessException e) {
            throw new MyDataAccessException("Subject getting by id error");
        }
    }

    public List<Subject> getSubjects() {
        return jdbcTemplate.query("select * from Subject", subjectRowMapper, new Object[]{});
    }

    public void updateSubject(long id, String name) {
        jdbcTemplate.update(
                "update Subject set name = ? where id = ?",
                new Object[]{name, id},
                new int[]{Types.VARCHAR, Types.BIGINT}
        );
    }

    public void deleteSubjectById(long id) {
        jdbcTemplate.update(
                "delete from Subject where id = ?",
                new Object[]{id},
                new int[]{Types.BIGINT}
        );
    }

    public void deleteSubject() {
        jdbcTemplate.update(
                "delete from Subject"
        );
    }
}
