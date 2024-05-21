package org.example.springlab.repositories;

import org.example.springlab.entities.Group;
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
public class GroupRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Group> groupRowMapper;

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.groupRowMapper = (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Group(id, name);
        };
    }

    public long saveGroup(String name) {
        String sql = "insert into MyGroup (name) values (?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, name);
            return preparedStatement;
        };
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    public Group getGroupById(long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from MyGroup where id = ?",
                    new Object[]{id},
                    new int[]{Types.BIGINT},
                    groupRowMapper);
        } catch (DataAccessException e) {
            throw new MyDataAccessException("Group getting by id error");
        }
    }

    public List<Group> getGroups() {
        return jdbcTemplate.query("select * from MyGroup", groupRowMapper, new Object[]{});
    }

    public void updateGroup(long id, String name) {
        jdbcTemplate.update(
                "update MyGroup set name = ? where id = ?",
                new Object[]{name, id},
                new int[]{Types.VARCHAR, Types.BIGINT}
        );
    }

    public void deleteGroupById(long id) {
        jdbcTemplate.update(
                "delete from MyGroup where id = ?",
                new Object[]{id},
                new int[]{Types.BIGINT}
        );
    }

    public void deleteGroups() {
        jdbcTemplate.update(
                "delete from MyGroup"
        );
    }
}
