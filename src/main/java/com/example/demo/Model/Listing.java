package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Listing {
    @Id
    private int listingId;
    private double price;
    private String name;
    private String description;
    private String uploadTime;
    private String email;

    public Listing ()
    {
    }

    public int getListingId ()
    {
        return listingId;
    }

    public void setListingId (int listingId)
    {
        this.listingId = listingId;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double price)
    {
        this.price = price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getUploadTime ()
    {
        return uploadTime;
    }

    public void setUploadTime (String uploadTime)
    {
        this.uploadTime = uploadTime;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }
}
