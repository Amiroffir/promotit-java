package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.DTOs.DeliveryDTO;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.services.BusinessService;
import com.amiroffir.promotitjava.services.LogServices.LogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DeliveryDTO> getDeliveries(@PathVariable String email) {
        try {
            logService.logInfo("Getting deliveries for " + email + " in BusinessRepController.getDeliveries()");
            return businessService.getDeliveries(email);
        } catch (Exception e) {
            logService.logError("Failed to get deliveries" + e.getMessage());
            return null;
        }
    }

    @PutMapping("/api/BusinessReps/UpdateDelivered/{serialNumber}")
    public Boolean updateDelivery(@PathVariable int serialNumber) {
        try {
            logService.logInfo("Updating delivery " + serialNumber + " in BusinessRepController.updateDelivery()");
            return businessService.updateDelivery(serialNumber);
        } catch (Exception e) {
            logService.logError("Failed to update delivery" + e.getMessage());
            return false;
        }
    }
}