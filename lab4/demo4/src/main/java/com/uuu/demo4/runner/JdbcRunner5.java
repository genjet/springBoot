package com.uuu.demo4.runner;

import com.uuu.demo4.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(5)
public class JdbcRunner5 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    private static final String SQL = "SELECT id, username, password FROM users2 WHERE id=:id";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue("id", 1);
        User user = template.queryForObject(SQL, parameter,
                (rs, rowNum) -> new User(rs.getString("username"), rs.getString("password")));
        log.info("username={},password={}", user.getUsername(), user.getPassword());

    }
}