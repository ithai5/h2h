package com.example.demo;

import com.example.demo.Model.Listing;
import com.example.demo.Model.User;
import com.example.demo.Service.ListingService;
import com.example.demo.Repository.DbInteraction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        String hola = "SELECT * FROM user";
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

        //Upload time is done by SQL automatically
        //test.setUploadTime("1970-01-01 00:00:01");
        test.setLocation("Copenhagen");

        assertEquals(true, service.addListing(test));

        test.setEmail("moses@theRealJesus.com");
        assertEquals(true, service.addListing(test));

        test.setEmail("test@email.com");
        assertEquals(true, service.addListing(test));
    }

    @Test
    void fetchAll()
    {
        System.out.println(service.fetchAll());
    }
    @Test
    void sqlPrevent(){
        DbInteraction dbInteraction = new DbInteraction();
        assertEquals("" , dbInteraction.sqlPrevent(""));
        assertEquals("this is good input", dbInteraction.sqlPrevent("this is good input"), "this is not a sql injection");
        assertEquals(null, dbInteraction.sqlPrevent("this != looks wrong"), "this is sql injection");
        assertEquals(null , dbInteraction.sqlPrevent("what ever ;"), "this is sql injection");
    }

}
