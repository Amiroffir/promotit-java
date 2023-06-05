package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String productId;
    public String productName;
    public double price;
    @ManyToOne
    @JoinColumn(name = "donated_by")
    public User donatedBy;
    @ManyToOne
    @JoinColumn(name = "donated_to")
    public Campaign donatedTo;
    public boolean isBought;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    public SocialActivist buyerID;
    public boolean isDelivered;
    @Column(length = 100000)
    public String image;
}