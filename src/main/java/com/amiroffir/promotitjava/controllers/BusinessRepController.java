package com.amiroffir.promotitjava.controllers;


import com.amiroffir.promotitjava.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BusinessRepController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/api/BusinessReps/GetDeliveries/{email}")
    public String getDeliveries(@PathVariable String email) {
        return email;
    }

    @PutMapping("/api/BusinessReps/UpdateDelivered/{serialNumber}")
    public String updateDelivery(@PathVariable String serialNumber) {
        return serialNumber;
    }
}