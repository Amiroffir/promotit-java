package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.models.BusinessRep;
import com.amiroffir.promotitjava.models.Delivery;
import com.amiroffir.promotitjava.models.Product;
import com.amiroffir.promotitjava.repos.BusinessRepo;
import com.amiroffir.promotitjava.repos.ProductRepo;
import com.amiroffir.promotitjava.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {


    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    public List<Delivery> getDeliveries(String email) {

        return null;
    }
}