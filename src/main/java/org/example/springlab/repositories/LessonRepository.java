package org.example.springlab.repositories;

import org.example.springlab.entities.Lesson;
import org.example.springlab.exceprions.MyDataAccessException;
import org.example.springlab.utils.pojos.CreateOrUpdateLessonPojo;
import org.example.springlab.utils.rowMappers.LessonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
public class LessonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final LessonRowMapper lessonRowMapper;

    @Autowired
    public LessonRepository(JdbcTemplate jdbcTemplate, LessonRowMapper lessonRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.lessonRowMapper = lessonRowMapper;
    }

    public long saveLesson(CreateOrUpdateLessonPojo pojo) {
        String sql = "insert into Lesson (date, time, teacher_id, group_id, subject_id) values (?, ?, ?, ?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setDate(1, pojo.getDate());
            preparedStatement.setTime(2, pojo.getTime());
            preparedStatement.setLong(3, pojo.getTeacherId());
            preparedStatement.setLong(4, pojo.getGroupId());
            preparedStatement.setLong(5, pojo.getSubjectId());
            return preparedStatement;
        };
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    public Lesson getLessonById(long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from Lesson where id = ?",
                    new Object[]{id},
                    new int[]{Types.BIGINT},
                    lessonRowMapper
            );
        } catch (DataAccessException e) {
            throw new MyDataAccessException("Student getting by id error");
        }
    }

    public List<Lesson> getLessons() {
        return jdbcTemplate.query("select * from Lesson", lessonRowMapper, new Object[]{});
    }

    public void updateLesson(long id, CreateOrUpdateLessonPojo pojo) {
        jdbcTemplate.update(
                "update Lesson set date = ?, time = ?, teacher_id = ?, group_id = ?, subject_id = ? where id = ?",
                new Object[]{pojo.getDate(), pojo.getTime(), pojo.getTeacherId(), pojo.getGroupId(), pojo.getSubjectId(), id},
                new int[]{Types.DATE, Types.TIME, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT}
        );
    }

    public void deleteLessonById(long id) {
        jdbcTemplate.update(
                "delete from Lesson where id = ?",
                new Object[]{id},
                Types.BIGINT
        );
    }

    public void deleteLessons() {
        jdbcTemplate.update(
                "delete from Lesson"
        );
    }
}
