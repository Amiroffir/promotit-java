package com.amiroffir.promotitjava.DTOs;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductDTO {
    public int id;
    public String productId;
    public String productName;
    public double price;
    public String donatedBy;
    public String donatedTo;
    public boolean isBought;
    public String buyerID;
    public String isDelivered;
    public String image;
}