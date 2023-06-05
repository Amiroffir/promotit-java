package com.amiroffir.promotitjava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    private int productSerialNumber;

    @OneToOne
    @MapsId // maps the primary key of the referenced entity to the primary key of the referencing entity
    private Product product;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private SocialActivist buyer;

    @ManyToOne
    @JoinColumn(name = "business_rep_id")
    private BusinessRep businessRep;

}