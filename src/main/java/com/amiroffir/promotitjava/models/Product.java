package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productId;
    private String productName;
    private double price;
    @ManyToOne
    @JoinColumn(name = "donated_by")
    private User donatedBy;
    @ManyToOne
    @JoinColumn(name = "donated_to")
    private Campaign donatedTo;
    private boolean isBought;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private SocialActivist buyerID;
    private boolean isDelivered;
    @Column(length = 100000)
    private String image;
}