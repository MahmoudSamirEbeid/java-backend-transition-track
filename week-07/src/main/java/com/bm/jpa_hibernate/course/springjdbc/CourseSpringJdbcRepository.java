package com.bm.jpa_hibernate.course.springjdbc;

import com.bm.jpa_hibernate.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseSpringJdbcRepository {

    private static final String INSERT_QUERY = """
            insert into course (id, name, author)
            values (?, ?, ?)
            """;
    private static final String DELETE_QUERY = "delete from course where id = ?";
    private static final String SELECT_QUERY = "select * from course where id = ?";
    private static final String SELECT_ALL_QUERY = "select * from course order by id";

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Course> rowMapper = (resultSet, rowNumber) -> new Course(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getString("author")
    );

    public CourseSpringJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Course course) {
        jdbcTemplate.update(
                INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, rowMapper, id);
    }

    public List<Course> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, rowMapper);
    }
}
