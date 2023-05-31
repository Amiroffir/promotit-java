package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/delivery")

    public String getDeliveries() {
        return "[ List.of();]";


    }
}