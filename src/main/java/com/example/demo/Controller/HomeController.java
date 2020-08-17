package com.example.demo.Controller;

import com.example.demo.Service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ListingService listingService;
    @GetMapping("/")
    public String mainPage (Model model){
        model.addAttribute("listings", listingService.viewLatestListing(5));
        return "/index";
    }

}
