package com.amiroffir.promotitjava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String campaignName;
    public String campaignDesc;
    public String campaignHash;
    public String campaignUrl;
    public double donationsAmount;
    public String nonProfitRepID;
    public String image;
}