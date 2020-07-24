package com.example.demo.Service;

import com.example.demo.Model.Listing;
import com.example.demo.Repository.ListingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    @Autowired
    ListingRepo listingRepo;

    public List<Listing> fetchAll(){
        return listingRepo.fetchAll();
    }

    public boolean addListing(Listing listing){
        System.out.println(listing);
        return listingRepo.addListing(listing);
    }

    // need to implement in a future point
    //public boolean searchListing(Listing listing){
    //    return listingRepo.searchListing(listing);
    //}

    public boolean deleteListing (int listingId){
        return listingRepo.deleteListing(listingId);
    }
    

}
