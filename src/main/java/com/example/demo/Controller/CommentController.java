package com.example.demo.Controller;

import com.example.demo.Model.Comment;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/postComment/{listingId}")
    public String postComment(@ModelAttribute Comment newComment, @PathVariable("listingId") int listingId){
        System.out.println(newComment);
        System.out.println(listingId);
        newComment.setCommentBoxId(commentService.fetchBoxForListing(listingId));
        newComment.setEmail(UserController.loginInfo.getEmail());
        commentService.addComment(newComment);
        return "redirect:/";
    }

}
