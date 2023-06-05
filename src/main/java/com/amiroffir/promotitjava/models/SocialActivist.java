package com.amiroffir.promotitjava.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@DiscriminatorValue("social_activist")
public class SocialActivist extends User {
    public String address;
    public String phone;
    public double earningStatus;
    public String twitterHandle;
    public Date lastEarningsUpdate;
}