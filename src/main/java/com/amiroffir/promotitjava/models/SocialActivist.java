package com.amiroffir.promotitjava.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@DiscriminatorValue("social_activist")
public class SocialActivist extends User {
    private String address;
    private String phone;
    private double earningStatus;
    private String twitterHandle;
    private Date lastEarningsUpdate;
}