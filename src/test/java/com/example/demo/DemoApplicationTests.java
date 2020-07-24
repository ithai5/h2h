package com.example.demo;

import com.example.demo.Model.Listing;
import com.example.demo.Model.User;
import com.example.demo.Service.ListingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    JdbcTemplate test;
    @Autowired
    ListingService service;

    @Test
    void contextLoads ()
    {
    }

    @Test
    void dbConnection() {
        String hola = "SELECT * FROM h2h.user";
        RowMapper<User> row = new BeanPropertyRowMapper<>(User.class);
        User yo = test.query(hola, row).get(0);
        System.out.println(yo.getName());
    }

    @Test
    void addToDb() {
        Listing test = new Listing();
        test.setDescription("I want somebody to fix my sink");
        test.setEmail("morgerfreeman@therealgod.dk");
        test.setName("Captain Sink");
        test.setPrice(45.5);
        //test.setUploadTime("1970-01-01 00:00:01");
        test.setLocation("Copenhagen");

        assertEquals(true, service.addListing(test));
    }

    @Test
    void fetchAll() {
        System.out.println(service.fetchAll());
    }
}
