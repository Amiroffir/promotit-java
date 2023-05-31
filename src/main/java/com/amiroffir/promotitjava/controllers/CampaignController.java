package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.models.Campaign;
import com.amiroffir.promotitjava.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/api/Campaigns/Add")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return campaign;
    }

    @DeleteMapping
    public String deleteCampaign(@PathVariable String id) {
        return id;
    }

    @PutMapping("/api/Campaigns/Update")
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        return campaign;
    }

    @GetMapping("/api/Campaigns/Get")
    public List<Campaign> getCampaigns() {
        return List.of(new Campaign());
    }

    @GetMapping("/api/Campaigns/GetCampaignDetails/{id}")
    public Campaign getCampaign(@PathVariable String id) {
        return new Campaign();
    }

    @GetMapping("/api/Campaigns/GetMyCampaigns/{email}")
    public List<Campaign> getMyCampaigns(@PathVariable String email) {
        return List.of(new Campaign());
    }
}