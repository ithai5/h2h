package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbInteraction {
    @Autowired
    JdbcTemplate template;

    public String sqlPrevent(String toCheck) {
        String [] badInput ={";","=","+"};
        for (int i = 0 ; i<badInput.length ; i++){
            if (toCheck.contains(badInput[i])){
                return null;
            }
        }
        return toCheck;
    }
}
