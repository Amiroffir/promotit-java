package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.services.AuthService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getRoles(@PathVariable String id) {
        try {
            logService.logInfo("Getting roles for user " + id);
            String response = authService.getRolesFromAuth0(id);
            logService.logInfo("Roles for user " + id + " retrieved successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logService.logError("Error getting roles for user " + id + ": " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}