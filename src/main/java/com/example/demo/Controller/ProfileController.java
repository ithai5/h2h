package com.example.demo.Controller;

import com.example.demo.Service.CommentService;
import com.example.demo.Service.ListingService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    ListingService lService;
    @Autowired
    CommentService cService;
    @Autowired
    UserService uService;

    @GetMapping("/profile")
    public String currentUserProfile(Model model) {
        model.addAttribute("currentUser", UserController.loginInfo);
        model.addAttribute("listings", lService.viewUserListing(UserController.loginInfo.getEmail()));
        model.addAttribute("comments", cService.showCommentForBox(cService.fetchBoxForUser(UserController.loginInfo.getEmail()).get(0).getCommentBoxId()));
        return "/user/currentUserProfile";
    }

    @PostMapping ("/profile/{email}")
    public String viewUserProfile(@PathVariable("email") String email, Model model) {
        model.addAttribute("user", uService.fetchUserByEmail(email));
        model.addAttribute("listings", lService.viewUserListing(email));
        model.addAttribute("comments", cService.showCommentForBox(cService.fetchBoxForUser(email).get(0).getCommentBoxId()));
        return "/user/currentUserProfile";
    }

}
