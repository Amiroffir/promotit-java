package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.services.LogServices.LogService;
import com.amiroffir.promotitjava.services.SocialActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SocialActivistController {
    @Autowired
    private SocialActService socialActService;
    @Autowired
    private LogService logService;

    @PutMapping("/api/SocialActivists/UpdateWallet/{amount}")
    public boolean updateWallet(@PathVariable String amount, @RequestBody String email) {
        try {
            logService.logInfo(
                    "Updating wallet for " + email + " with " + amount + " in SocialActivistController.updateWallet()");
            return socialActService.updateWallet(amount, email);
        } catch (Exception e) {
            logService.logError("Failed to update wallet " + e.getMessage());
            return false;
        }
    }

    @GetMapping("/api/SocialActivists/GetWallet/{email}")
    public String getWallet(@PathVariable String email) {
        try {
            logService.logInfo("Getting wallet for " + email + " in SocialActivistController.getWallet()");
            return socialActService.getWallet(email);
        } catch (Exception e) {
            logService.logError("Failed to get wallet " + e.getMessage());
            return null;
        }
    }
}