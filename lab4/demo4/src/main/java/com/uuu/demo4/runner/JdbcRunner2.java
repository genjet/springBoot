package com.uuu.demo4.runner;

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
@Order(2)
public class JdbcRunner2 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static final String SQL1 = "SELECT :a + :b - :c * :d";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue("a", 100).addValue("b", 200)
                .addValue("c", 4).addValue("d", 300);

        Integer integerResult = jdbcTemplate.queryForObject(SQL1, parameter, Integer.class);
        log.info("execute:{}, result={}", SQL1, integerResult);
    }
}
