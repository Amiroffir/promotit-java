package com.amiroffir.promotitjava.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UpdateCampaignDTO {
    private int id;
    @JsonProperty("CampaignName")
    private String campaignName;
    @JsonProperty("CampaignDesc")
    private String campaignDesc;
    @JsonProperty("CampaignHash")
    private String campaignHash;
    @JsonProperty("CampaignUrl")
    private String campaignUrl;
}