package com.amiroffir.promotitjava.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CampaignDTO {
    public int id;
    @JsonProperty("CampaignName")
    public String campaignName;
    @JsonProperty("CampaignDesc")
    public String campaignDesc;
    @JsonProperty("CampaignHash")
    public String campaignHash;
    @JsonProperty("CampaignUrl")
    public String campaignUrl;
    @JsonProperty("DonationsAmount")
    public double donationsAmount;
    @JsonProperty("NonProfitRepID")
    public String nonProfitRep;
    @JsonProperty("Image")
    public String image;
}