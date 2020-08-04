package com.example.demo.Repository;

import com.example.demo.Model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListingRepo extends DbInteraction {

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
        String query = "INSERT INTO listing(price, name, description, email, location)\n" +
                "VALUES(?,?,?,?,?)";
        template.update(query, toAdd.getPrice(), toAdd.getName(), toAdd.getDescription(),
                toAdd.getEmail(), toAdd.getLocation());
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
                "WHERE email = ?" ;
        RowMapper<Listing> rowMapper = new BeanPropertyRowMapper<>(Listing.class);
        return template.query(query, rowMapper, email);
    }
}
