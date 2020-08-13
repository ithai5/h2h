package com.example.demo.Repository;

import com.example.demo.Model.Comment;
import com.example.demo.Model.CommentBox;
import com.example.demo.Model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepo extends DbInteraction {

    public List<Comment> showCommentForBox(int commentBoxId){
        String query = "SELECT * FROM comment WHERE commentBoxId = ? ORDER BY uploadTime ";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return template.query(query,rowMapper,commentBoxId);
    }

    public List<CommentBox> fetchBoxForUser(String email) {
        String query = "SELECT * FROM commentbox WHERE email = ?";
        RowMapper<CommentBox> rowMapper = new BeanPropertyRowMapper<>(CommentBox.class);
        return template.query(query, rowMapper, email);
    }

    public boolean addComment(Comment comment){
        String query = "INSERT INTO comment (email, content, commentBoxId)" +
                " VALUES (?,?,?)";
         if (template.update(query,comment.getEmail(),comment.getContent(),comment.getCommentBoxId())==1){
             return true;
         }
        return false;
    }

    public boolean createProfileCommentBox(String email){
        String query = "INSERT INTO commentBox (email, canComment) VALUES (?,?)";
        int result = template.update(query,email,1);
        if (result>0){
            return true;
        }
        return false;
    }


}
