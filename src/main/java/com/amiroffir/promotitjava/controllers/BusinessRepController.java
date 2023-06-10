package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.DTOs.DeliveryDTO;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.services.BusinessService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BusinessRepController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private LogService logService;

    @GetMapping("/api/BusinessReps/GetDeliveries/{email}")
    public ResponseEntity<List<DeliveryDTO>> getDeliveries(@PathVariable String email) {
        try {
            logService.logInfo("Getting deliveries for " + email + " in BusinessRepController.getDeliveries()");
            List<DeliveryDTO> deliveries = businessService.getDeliveries(email);
            return ResponseEntity.ok(deliveries);
        } catch (Exception e) {
            logService.logError("Failed to get deliveries" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/api/BusinessReps/UpdateDelivered/{serialNumber}")
    public ResponseEntity<Boolean> updateDelivery(@PathVariable int serialNumber) {
        try {
            logService.logInfo("Updating delivery " + serialNumber + " in BusinessRepController.updateDelivery()");
            boolean isUpdated = businessService.updateDelivery(serialNumber);
            if (isUpdated) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            logService.logError("Failed to update delivery" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}