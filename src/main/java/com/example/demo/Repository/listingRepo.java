package com.example.demo.Repository;

import com.example.demo.Model.Listing;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListingRepo extends DbInteraction {

    @Autowired
    CommentService commentService;

    public List<Listing> fetchAll() {
        String query = "SELECT * FROM listing;";
        RowMapper<Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query, rowMapper);
    }

    public boolean addListing(Listing toAdd) {
        //Check for injection
        if (sqlPrevent(toAdd.toString()) == null) {
            return false;
        }
        String query = "INSERT INTO listing(price, name, description, email, location, categoryId)\n" +
                "VALUES(?,?,?,?,?,?)";
        template.update(query, toAdd.getPrice(), toAdd.getName(), toAdd.getDescription(),
                toAdd.getEmail(), toAdd.getLocation(), toAdd.getCategoryId());

        commentService.createListingCommentBox(toAdd.getEmail(), toAdd.getListingId());

        return true;
    }

    public boolean deleteListing(int listingId) {
        String query = "DELETE FROM listing WHERE listingId = ?";
        template.update(query, listingId);
        return true;
    }

    public Listing viewListing(int listingId){
        String query = "SELECT * FROM listing " +
                "WHERE listingId = ? ";
        RowMapper<Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query,rowMapper, listingId).get(0);
    }

    public List<Listing> viewUserListing (String email){
        String query =  "SELECT * FROM listing " +
                "WHERE email = ? ORDER BY uploadTime DESC " ;
        RowMapper<Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query, rowMapper, email);
    }

    public List<Listing> viewLatestListing(int amount){
        String query = "SELECT * FROM listing " +
                        "ORDER BY uploadTime DESC " +
                        "LIMIT ?";
        RowMapper<Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query,rowMapper,amount);
    }

    public List<Listing> viewListingByCategory(int categoryId){
        String query = "SELECT * FROM listing " +
                "WHERE categoryId = ? " +
                "ORDER BY uploadTime DESC";
        RowMapper <Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query, rowMapper, categoryId);
    }
}
