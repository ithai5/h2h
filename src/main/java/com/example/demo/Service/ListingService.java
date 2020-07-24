package com.example.demo.Service;

import com.example.demo.Model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {
    @Autowired ListingRepo listingRepo;

    public String fetchAll(){
        return listingRepo.featchAll();
    }

    public boolean addListing(Listing listing){
        return listingRepo.addListing(listing);
    }

    // need to implement in a future point
    //public boolean searchListing(Listing listing){
    //    return listingRepo.searchListing(listing);
    //}

    public boolean  deleteListing (int listingId){
        return listingRepo.deleteListing(listingId);
    }
    

}
