package com.uuu.demo4.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.security.spec.NamedParameterSpec;

@Component
@Slf4j
@Order(1)
public class JdbcRunner1 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static final String SQL1 = "SELECT 123+321";

    @Override
    public void run(String... args) throws Exception {
        log.info("jdbc template:{}", jdbcTemplate);
        log.info("get jdbc template inside NameParameterJdbcTemplate:{}", jdbcTemplate.getJdbcTemplate());
        log.info("get data source:{}", jdbcTemplate.getJdbcTemplate().getDataSource());
        log.info("get connection from data source:{}", jdbcTemplate.getJdbcTemplate().getDataSource().getConnection());
        SqlParameterSource source = new MapSqlParameterSource();
        Integer integerResult = jdbcTemplate.queryForObject(SQL1, source, Integer.class);
        log.info("execute:{}, result={}", SQL1, integerResult);

        log.trace("JdbcRunner1 log trace ");
        log.debug("JdbcRunner1 log debug ");
    }
}
