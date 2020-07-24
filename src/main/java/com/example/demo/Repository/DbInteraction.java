package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DbInteraction {
    @Autowired
    JdbcTemplate template;

    public String sqlPrevent(String toCheck) {
        return toCheck;
    }
}
