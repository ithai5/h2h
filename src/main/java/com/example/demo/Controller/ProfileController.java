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
    UserService uService;
    @Autowired
    ListingService lService;
    @Autowired
    CommentService cService;

    User currentUser = UserController.loginInfo;

    @GetMapping("/profile")
    public String currentUserProfile(Model model) {
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("listings", lService.viewUserListing(currentUser.getEmail()));
        model.addAttribute("comments", cService.showCommentForBox(cService.showBoxesForProfile(currentUser.getEmail()).get(0).getCommentBoxId()));
        return "/user/currentUserProfile";
    }

}
