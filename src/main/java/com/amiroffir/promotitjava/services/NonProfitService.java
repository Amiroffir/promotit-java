package com.amiroffir.promotitjava.services;

import com.amiroffir.promotitjava.repos.NonProfitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonProfitService {
    @Autowired
    private NonProfitRepo nonProfitRepo;
}