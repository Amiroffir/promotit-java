package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BusinessRepController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/api/BusinessReps/GetDeliveries/{email}")
    public List<Delivery> getDeliveries(@PathVariable String email) {
        try {
            return businessService.getDeliveries(email);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/api/BusinessReps/UpdateDelivered/{serialNumber}")
    public String updateDelivery(@PathVariable String serialNumber) {
        return serialNumber;
    }
}