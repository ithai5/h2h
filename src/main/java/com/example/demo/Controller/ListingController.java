package com.example.demo.Controller;


import com.example.demo.Model.Listing;
import com.example.demo.Service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListingController {
    @Autowired
    ListingService listingService;

    @GetMapping("/createNewListing")
    public String fillListing(){
        return "listing/addListing";
    }

    @PostMapping("/createNewListing")
    public String addNewListing(@ModelAttribute Listing listing){
        listing.setEmail("moses@theRealJesus.com"); //just for checking;
        listingService.addListing(listing);
        return "redirect:/";//need to change to another landing page
    }
}
