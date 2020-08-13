package com.example.demo.Service;

import com.example.demo.Model.Comment;
import com.example.demo.Model.CommentBox;
import com.example.demo.Model.User;
import com.example.demo.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    public List<Comment> showCommentForBox(int commentBoxId){
        return commentRepo.showCommentForBox(commentBoxId);
    }

    public List<CommentBox> fetchBoxForUser(String email) {return commentRepo.fetchBoxForUser(email);}

    public boolean addComment(Comment comment){
        return commentRepo.addComment(comment);
    }

    public boolean createProfileCommentBox(String email){
        return commentRepo.createProfileCommentBox(email);
    }
}
