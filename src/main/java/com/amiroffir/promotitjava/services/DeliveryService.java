package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.repos.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This annotation tells Spring that this class is a service class that can be injected to other classes
public class DeliveryService {

    @Autowired // This annotation tells Spring to inject an instance of DeliveryRepo here
    private DeliveryRepo deliveryRepo;
    
    public List<Delivery> getDeliveries() {
        System.out.println(deliveryRepo.findAll().toString());
        return deliveryRepo.findAll();
    }
}