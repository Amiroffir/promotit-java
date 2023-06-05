package com.amiroffir.promotitjava.controllers;

import com.amiroffir.promotitjava.DTOs.CampaignDTO;
import com.amiroffir.promotitjava.DTOs.UpdateCampaignDTO;
import com.amiroffir.promotitjava.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/api/Campaigns/Add")
    public CampaignDTO addCampaign(@RequestBody CampaignDTO campaign) {
        try {
            return campaignService.addCampaign(campaign);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/api/Campaigns/Delete/{id}")
    public Boolean deleteCampaign(@PathVariable String id) {
        try {
            return campaignService.deleteCampaign(id);
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/api/Campaigns/Update")
    public CampaignDTO updateCampaign(@RequestBody UpdateCampaignDTO campaign) {
        try {
            return campaignService.updateCampaign(campaign);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/Campaigns/Get")
    public List<CampaignDTO> getCampaigns() {
        try {
            return campaignService.getCampaigns();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/Campaigns/GetCampaignDetails/{id}")
    public CampaignDTO getCampaign(@PathVariable int id) {
        try {
            return campaignService.getCampaign(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/Campaigns/GetMyCampaigns/{email}")
    public List<CampaignDTO> getMyCampaigns(@PathVariable String email) {
        try {
            return campaignService.getMyCampaigns(email);
        } catch (Exception e) {
            return null;
        }
    }
}