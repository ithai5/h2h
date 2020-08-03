package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //Ensured we're always logged in
    public static User loginInfo;

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/validating")
    public String loginCheck(@ModelAttribute User user) {
        System.out.println(user);

        loginInfo = userService.validateUser(user);

        System.out.println(loginInfo);

        if (loginInfo == null) {
            //Return to error screen
            return "redirect:/";
        }
        return "redirect:/viewAllListing";
    }
    
    public String logOut() {
        loginInfo = null;
        return "redirect:/";
    }
}
