package com.example.demo.Controller;

import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/postComment")
    public String postComment(){

        return
    }

}
