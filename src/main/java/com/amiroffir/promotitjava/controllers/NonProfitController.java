package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.services.NonProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RestController
public class NonProfitController {
    @Autowired
    private NonProfitService nonProfitService;
}