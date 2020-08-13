package com.example.demo.Repository;

import com.example.demo.Model.User;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepo extends DbInteraction {

    @Autowired
    CommentService commentService;
    public User validateUser(User user) {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> hits = template.query(query, rowMapper, user.getEmail(), user.getPassword());

        if (hits.isEmpty()) {
            return null;
        }
        return hits.get(0);
    }

    public boolean createNewUser (User user){
        String query = "INSERT INTO user (email, password, name, phone, description) VALUES " +
                        "(?,?,?,?,?)";
        int creatingUser = template.update(query,user.getEmail(),user.getPassword(),user.getName(), user.getPhone(),user.getDescription());
        boolean creatingCommentBox = commentService.createProfileCommentBox(user.getEmail());
        if (creatingUser>0 && creatingCommentBox){
            return true;
        }
        else{
            return false;
        }
    }

    public User fetchUserByEmail(String email){
        String query = "SELECT * FROM user WHERE email = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(query,rowMapper,email).get(0);
    }
}