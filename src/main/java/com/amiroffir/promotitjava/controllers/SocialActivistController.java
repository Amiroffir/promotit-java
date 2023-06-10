package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.services.LogServices.LogService;
import com.amiroffir.promotitjava.services.SocialActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@CrossOrigin
@RestController
public class SocialActivistController {
    @Autowired
    private SocialActService socialActService;
    @Autowired
    private LogService logService;

    @PutMapping("/api/SocialActivists/UpdateWallet/{amount}")
    public ResponseEntity<Boolean> updateWallet(@PathVariable String amount, @RequestBody String email) {
        try {
            logService.logInfo(
                    "Updating wallet for " + email + " with " + amount + " in SocialActivistController.updateWallet()");
            boolean response = socialActService.updateWallet(amount, email);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException.NotFound e) {
            logService.logError("Failed to update wallet " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/SocialActivists/GetWallet/{email}")
    public ResponseEntity<String> getWallet(@PathVariable String email) {
        try {
            logService.logInfo("Getting wallet for " + email + " in SocialActivistController.getWallet()");
            String walletResponse = socialActService.getWallet(email);
            return ResponseEntity.ok(walletResponse);
        } catch (HttpClientErrorException.NotFound e) {
            logService.logError("Failed to get wallet " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}