package com.amiroffir.promotitjava.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CampaignDTO {
    private int id;
    @JsonProperty("CampaignName")
    private String campaignName;
    @JsonProperty("CampaignDesc")
    private String campaignDesc;
    @JsonProperty("CampaignHash")
    private String campaignHash;
    @JsonProperty("CampaignUrl")
    private String campaignUrl;
    @JsonProperty("DonationsAmount")
    private double donationsAmount;
    @JsonProperty("NonProfitRepID")
    private String nonProfitRep;
    @JsonProperty("Image")
    private String image;
}