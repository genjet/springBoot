package com.uuu.demo4.runner;

import com.uuu.demo4.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
@Order(4)
public class JdbcRunner4 implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String DROP_DDL = "DROP TABLE users IF EXISTS";
    private static final String CREATE_DDL = "CREATE TABLE users(id SERIAL, username VARCHAR(255), password VARCHAR(255))";
    private static final String INSERT_DML = "INSERT INTO USERS(USERNAME, PASSWORD) VALUES(?,?)";
    private static final String SELECT_DML = "SELECT * FROM USERS";
    private static final String SELECT_DML2 = "SELECT id, username, password FROM USERS WHERE username=?";

    private static final String USER1 = "Mark password1";
    private static final String USER2 = "John password2";
    private static final String USER3 = "Ken password3";
    private static final String USER4 = "Tim password4";

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute(DROP_DDL);
        jdbcTemplate.execute(CREATE_DDL);
        List<Object[]> users = Stream.of(USER1, USER2, USER3, USER4)
                .map(s -> s.split(" ")).collect(Collectors.toList());
        jdbcTemplate.batchUpdate(INSERT_DML, users);
        List<User> queryUsers = jdbcTemplate.query(SELECT_DML, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")));
        log.info("query back and transform to list of users as:{}", queryUsers);
        jdbcTemplate.query(SELECT_DML, (rs, rowNum) ->
                        new User(rs.getString("username"), rs.getString("password")))
                .forEach(x -> log.info("get the user as:{}", x));
        jdbcTemplate.query(SELECT_DML, (rs, rowNum) -> {
            log.info("rowNum={},rs={}", rowNum, rs);
            return new User(rs.getString("username"), rs.getString("password"));
        });
        User userMark = jdbcTemplate.queryForObject(SELECT_DML2, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")), new Object[]{"Mark"});
        log.info("query by parameter, name=mark ==> {}",userMark);
    }
}