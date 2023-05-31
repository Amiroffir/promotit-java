package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.services.AuthService;
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

    @GetMapping("/api/roles/{id}")
    public String getRoles(@PathVariable String id) {
        String roles = authService.getRolesFromAuth0(id);
        return roles;
    }
}