package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int productSerialNumber;
    public String productID;
    public String productName;
    public double price;
    public String donatedBy;
    public String donatedTo;
    public boolean isBought;
    public String buyerID;
    public String isDelivered;
    public String image;
}