package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.services.SocialActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SocialActivistController {
    @Autowired
    private SocialActService socialActivistService;

    @PutMapping("/api/SocialActivists/UpdateWallet/{amount}")
    public String updateWallet(@PathVariable String amount, @RequestBody String email) {
        return amount + " " + email;
    }

    @GetMapping("/api/SocialActivists/GetWallet/{email}")
    public String getWallet(@PathVariable String email) {
        return email;
    }
}