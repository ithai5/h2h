package com.example.demo.Controller;


import com.example.demo.Model.Listing;
import com.example.demo.Service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
            listing.setEmail("morganfreeman@therealgod.dk"); //just for checking;
        listingService.addListing(listing);
        return "redirect:/";//need to change to another landing page
    }

    @GetMapping("/viewAllListing")
    public String viewAllListing(Model model){
        List<Listing> listListings = listingService.fetchAll();
        model.addAttribute("listings", listListings);
        return "listing/viewAllListing";
    }

    @PostMapping("/listing/viewAllListingByCategory/{categoryId}")
    public String viewAllListingByCategory(@PathVariable("categoryId") int categoryId,Model model){
        model.addAttribute("listings", listingService.viewListingByCategory(categoryId));
        return "listing/viewAllListing";
    }
    @PostMapping("/listing/viewListing/{listingId}")
    public String viewListing(@PathVariable("listingId") int listingId, Model model){
        Listing listing = listingService.viewListing(listingId);
        model.addAttribute("listing", listing);
        return "listing/viewListing";
    }

    //Need to change URL to more appropriate thing
    //(Also in viewListing.html)
    @PostMapping("/ll/{listingId}")
    public String deleteListing(@PathVariable("listingId") int listingId, Model model){
        Listing listing = listingService.viewListing(listingId);
        model.addAttribute("listing", listing);
        listingService.deleteListing(listingId);
        return "redirect:/";//need to change to another landing page
    }
}
