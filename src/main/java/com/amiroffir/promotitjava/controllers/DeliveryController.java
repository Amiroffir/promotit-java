package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/hello")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/")
    public List<Delivery> getDeliveries() {
        List<Delivery> deliveries = new ArrayList<>();
        deliveries = deliveryService.getDeliveries();
        return deliveries;

    }


}