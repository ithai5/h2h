package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepo extends DbInteraction {

    public User validateUser(User user) {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> hits = template.query(query, rowMapper, user.getEmail(), user.getPassword());

        if (hits.isEmpty()) {
            return null;
        }
        return hits.get(0);
    }
}