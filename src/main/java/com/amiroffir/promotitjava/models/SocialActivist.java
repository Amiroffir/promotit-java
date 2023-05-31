package com.amiroffir.promotitjava.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class SocialActivist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String userID;
    public String fullName;
    public String email;
    public String address;
    public String phone;
    public double earningStatus;
    public String twitterHandle;
    public Date lastEarningsUpdate;
}