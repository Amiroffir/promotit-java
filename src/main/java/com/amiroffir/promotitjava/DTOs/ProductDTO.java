package com.amiroffir.promotitjava.DTOs;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String productId;
    private String productName;
    private double price;
    private String donatedBy;
    private String donatedTo;
    private boolean isBought;
    private String buyerID;
    private String isDelivered;
    private String image;
}