package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/Get")
    public List<User> getUsers() {
        try {
            return userService.getUsers();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/users/GetUserDetails/{id}")
    public User getUserDetails(@PathVariable int id) {
        try {
            return userService.getUserDetails(id);
        } catch (Exception e) {
            return null;
        }
    }

}