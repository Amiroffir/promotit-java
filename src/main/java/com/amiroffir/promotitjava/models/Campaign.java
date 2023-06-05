package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String campaignName;
    public String campaignDesc;
    public String campaignHash;
    public String campaignUrl;
    public double donationsAmount;
    @ManyToOne
    @JoinColumn(name = "non_profit_rep_id")
    public User nonProfitRep;
    @Column(length = 100000)
    public String image;
}