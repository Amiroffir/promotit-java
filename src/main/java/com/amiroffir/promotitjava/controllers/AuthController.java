package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.services.AuthService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private LogService logService;

    @GetMapping("/api/roles/{id}")
    public String getRoles(@PathVariable String id) {
        try {
            logService.logInfo("Getting roles for user " + id);
            return authService.getRolesFromAuth0(id);
        } catch (Exception e) {
            logService.logError("Error getting roles for user " + id + ": " + e.getMessage());
            return null;
        }
    }
}