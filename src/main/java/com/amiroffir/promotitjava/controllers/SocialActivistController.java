package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.services.SocialActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SocialActivistController {
    @Autowired
    private SocialActService socialActService;

    @PutMapping("/api/SocialActivists/UpdateWallet/{amount}")
    public boolean updateWallet(@PathVariable String amount, @RequestBody String email) {
        try {
            return socialActService.updateWallet(amount, email);
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/api/SocialActivists/GetWallet/{email}")
    public String getWallet(@PathVariable String email) {
        try {
            return socialActService.getWallet(email);
        } catch (Exception e) {
            return null;
        }
    }
}