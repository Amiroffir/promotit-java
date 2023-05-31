package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class NonProfitRep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String userID;
    public String fullName;
    public String email;
    public String organizationUrl;
    public String organizationName;
}