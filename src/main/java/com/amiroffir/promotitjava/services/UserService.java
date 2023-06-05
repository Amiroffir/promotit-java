package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public List<User> getUsers() {
        try {
            List<User> userList = userRepo.findAll();
            return userList;
        } catch (Exception e) {
            throw e;
        }
    }

    public User getUserDetails(int id) {
        try {
            User user = userRepo.findById(id).orElseThrow();
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}