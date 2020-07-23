package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
   //ATTRIBUTES
    @Id
    private String name;
    private String email;
    private String description;
    private double rate;
    private String password;
    private String phone;
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    //CONSTRUCTORS
    public User() {}

    public User(String name, String email, String description, double rate, String password, String phone, String test) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.rate = rate;
        this.password = password;
        this.phone = phone;
        this.test = test;
    }

    //GETTERS + SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //toString + methods

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
