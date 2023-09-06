package com.api.config;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * fileName       : DataSourceTest
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */
@JdbcTest
public class DataSourceTest {
    @Autowired DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello_api(name varchar(50) primary key, count int)");
    }

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello_api values(?, ?)", "Toby", 3);
        jdbcTemplate.update("insert into hello_api values(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello_api", Long.class);
        assertThat(count).isEqualTo(2);
    }
}