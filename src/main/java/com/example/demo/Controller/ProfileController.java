package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.ListingService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    ListingService lService;
    @Autowired
    CommentService cService;

    @GetMapping("/profile")
    public String currentUserProfile(Model model) {
        System.out.println(UserController.loginInfo);
        model.addAttribute("currentUser", UserController.loginInfo);
        model.addAttribute("listings", lService.viewUserListing(UserController.loginInfo.getEmail()));
        model.addAttribute("comments", cService.showCommentForBox(cService.fetchBoxForUser(UserController.loginInfo.getEmail()).get(0).getCommentBoxId()));
        return "/user/currentUserProfile";
    }

}
