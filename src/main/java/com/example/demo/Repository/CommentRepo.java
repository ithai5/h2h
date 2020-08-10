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
        String query = "SELECT * FROM comment WHERE commentBoxId = ? OREDER BY uploadTime ";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return template.query(query,rowMapper,commentBoxId);
    }

    public List<CommentBox> showBoxesForProfile(String email) {
        String query = "SELECT * FROM commentbox WHERE email = ? AND listingId = null";
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


}
