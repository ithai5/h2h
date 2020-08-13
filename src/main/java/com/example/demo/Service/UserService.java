package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User validateUser (User user) {return userRepo.validateUser(user);}

    public User fetchUserByEmail (String email)
    {
        return userRepo.fetchUserByEmail(email);
    }
}