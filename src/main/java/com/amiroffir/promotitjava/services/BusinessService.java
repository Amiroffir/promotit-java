package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.DTOs.DeliveryDTO;
import com.amiroffir.promotitjava.models.BusinessRep;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.repos.BusinessRepo;
import com.amiroffir.promotitjava.repos.DeliveryRepo;
import com.amiroffir.promotitjava.repos.ProductRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private DeliveryRepo deliveryRepo;

    public List<DeliveryDTO> getDeliveries(String email) {
        try {
            List<Delivery> deliveries = deliveryRepo.findAll();
            deliveries.removeIf(delivery -> !delivery.getBusinessRep().getEmail().equals(email));
            // Now there is list of deliveries that belong to the business rep with the given email
            List<DeliveryDTO> deliveryDTOs = new ArrayList<>();
            for (Delivery delivery : deliveries) {
                DeliveryDTO deliveryDTO = modelMapper.map(delivery, DeliveryDTO.class);
                deliveryDTOs.add(deliveryDTO);
            }
            return deliveryDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public Boolean updateDelivery(int serialNumber) {
        try {
            Product product = productRepo.findById(serialNumber).orElseThrow();
            product.setDelivered(true);
            deliveryRepo.deleteByProduct(product);
            productRepo.save(product);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}