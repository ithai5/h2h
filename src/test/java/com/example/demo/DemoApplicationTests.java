package com.example.demo;

import com.example.demo.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    JdbcTemplate test;

    @Test
    void contextLoads ()
    {
    }


    @Test
    void dbConnection() {
        String hola = "SELECT * FROM h2h.user";
        RowMapper<User> row = new BeanPropertyRowMapper<>(User.class);
        User yo = test.query(hola, row).get(0);
        System.out.println(yo.getName());

    }
}
