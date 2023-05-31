package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/Get")
    public String getUsers() {
        return "get";
    }

    @GetMapping("/api/users/GetUserDetails/{id}")
    public String getUserDetails(@PathVariable String id) {
        return id;
    }

}