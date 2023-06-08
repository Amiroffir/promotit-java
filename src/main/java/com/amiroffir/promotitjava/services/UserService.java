package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.repos.UserRepo;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LogService logService;


    public List<User> getUsers() {
        try {
            List<User> userList = userRepo.findAll();
            logService.logInfo("Users list retrieved");
            return userList;
        } catch (Exception e) {
            logService.logError("Failed to retrieve users list" + e.getMessage());
            throw e;
        }
    }

    public User getUserDetails(int id) {
        try {
            User user = userRepo.findById(id).orElseThrow();
            logService.logInfo("User details retrieved");
            return user;
        } catch (Exception e) {
            logService.logError("Failed to retrieve user details" + e.getMessage());
            throw e;
        }
    }
}