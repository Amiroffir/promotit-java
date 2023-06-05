package com.amiroffir.promotitjava.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UpdateCampaignDTO {
    public int id;
    @JsonProperty("CampaignName")
    public String campaignName;
    @JsonProperty("CampaignDesc")
    public String campaignDesc;
    @JsonProperty("CampaignHash")
    public String campaignHash;
    @JsonProperty("CampaignUrl")
    public String campaignUrl;
}