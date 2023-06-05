package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class Delivery {
    @Id
    private int productSerialNumber;
    private int pid;
    private String fullName;
    private String email;
    private String address;
    private String phone;

}