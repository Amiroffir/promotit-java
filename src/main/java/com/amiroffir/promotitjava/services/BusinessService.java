package com.amiroffir.promotitjava.services;


import com.amiroffir.promotitjava.repos.BusinessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepo businessRepo;
}