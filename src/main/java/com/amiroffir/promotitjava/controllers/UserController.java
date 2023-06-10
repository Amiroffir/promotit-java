package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.User;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import com.amiroffir.promotitjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private LogService logService;

    @GetMapping("/api/users/Get")
    public List<User> getUsers() {
        try {
            logService.logInfo("Getting Users List in UserController.getUsers()");
            return userService.getUsers();
        } catch (Exception e) {
            logService.logError("Failed to get Users List " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/api/users/GetUserDetails/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id) {
        try {
            logService.logInfo("Getting User Details in UserController.getUserDetails()");
            User userResponse = userService.getUserDetails(id);
            if (userResponse == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(userResponse);
            }
        } catch (Exception e) {
            logService.logError("Failed to get User Details " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}