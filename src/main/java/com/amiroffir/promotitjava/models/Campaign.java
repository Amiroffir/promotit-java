package com.amiroffir.promotitjava.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String campaignName;
    private String campaignDesc;
    private String campaignHash;
    private String campaignUrl;
    private double donationsAmount;
    @ManyToOne
    @JoinColumn(name = "non_profit_rep_id")
    private User nonProfitRep;
    @Column(length = 100000)
    private String image;
}